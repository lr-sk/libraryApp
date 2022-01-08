//"use strict";

console.log(1);

alert("1");

window.onload = function() {
    debugger;
    validateBookCost();
};


function validateBookCost() {
    let bookCost = document.getElementById("bookCost").value;
    let regexp = /^\d+\.?\d*$/;

    if (!regexp.test(bookCost)) {
        bookCost.classList.add("is-invalid");
    } else {
        bookCost.classList.add("is-valid");
    }
}