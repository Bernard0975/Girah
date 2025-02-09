// script.js
'use strict';

// ... (your navbar, header, etc. code) ...

// Item code generation
function generateCode() {
    const characters = 'abcdefghijklmnopqrstuvwxyz0123456789';
    let code = '';
    for (let i = 0; i < 6; i++) {
        code += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    const codeInput = document.getElementById('code');
    if (codeInput) {
        codeInput.value = code.toUpperCase();
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const nameInput = document.getElementById('name');
    const weightInput = document.getElementById('weight');
    const codeInput = document.getElementById('code');
    const generateButton = document.getElementById('generateButton'); // Get the button

    if (nameInput && weightInput && codeInput && generateButton) {
        nameInput.addEventListener('input', generateCode);
        weightInput.addEventListener('input', generateCode);
        generateButton.addEventListener('click', generateCode); // Event listener for the button

        generateCode(); // Initial code generation

        const form = document.getElementById('itemForm');
        if (form) {
            form.addEventListener('submit', function(event) {
                event.preventDefault(); // Prevent default form submission

                // Handle the form submission here (e.g., AJAX, validation, etc.)
                console.log("Form submitted (but refresh prevented).  Now you can process the data.");

                // Example using FormData and fetch API (AJAX):
                const formData = new FormData(form);
                fetch(form.action, { // Use form.action for the URL
                    method: form.method, // Use form.method (POST)
                    body: formData
                })
                .then(response => response.json()) // Assuming JSON response
                .then(data => {
                    console.log("Success:", data); // Handle success (e.g., display message)
                })
                .catch(error => {
                    console.error("Error:", error); // Handle error
                });


            });
        } else {
            console.error("The form element with id 'itemForm' was not found.");
        }


    } else {
        console.error("One or more of the required elements (name, weight, code, generateButton) were not found.");
    }
});