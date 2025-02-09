@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello.world";
    }
    }


import java.util.HashMap;
import java.util.Map;

class Item {
    private String code;
    private String name;
    private double weight;

    public Item(String code, String name, double weight) {
        this.code = code;
        this.name = name;
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class VehicleInventory {
    private Map<String, Item> items;
    private double totalWeight;

    public VehicleInventory() {
        items = new HashMap<>();
        totalWeight = 0.0;
    }

    public boolean addItem(Item item) {
        if (items.containsKey(item.getCode())) {
            System.out.println("Item with code " + item.getCode() + " already exists.");
            return false;
        }
        items.put(item.getCode(), item);
        totalWeight += item.getWeight();
        return true;
    }

    public boolean removeItem(String code) {
        Item item = items.remove(code);
        if (item != null) {
            totalWeight -= item.getWeight();
            return true;
        }
        System.out.println("Item with code " + code + " does not exist.");
        return false;
    }

    public Item getItem(String code) {
        return items.get(code);
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void displayItems() {
        for (Item item : items.values()) {
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleInventory inventory = new VehicleInventory();

        Item item1 = new Item("A001", "Box", 15.5);
        Item item2 = new Item("A002", "hamper", 5.0);
        Item item3 = new Item("A003", "Bag ", 2.5);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        System.out.println("Total weight: " + inventory.getTotalWeight() + " kg");

        inventory.displayItems();

        inventory.removeItem("A002");

        System.out.println("Total weight after removal: " + inventory.getTotalWeight() + " kg");

        inventory.displayItems();
    }
}
