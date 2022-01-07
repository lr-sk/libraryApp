function validateBookCost() {
    let bookCost = document.getElementById("bookCost").value;
    let regexp = /^\d+\.?\d*$/;

    if (!regexp.test(bookCost)) {

    }
}