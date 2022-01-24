let fieldFuncMap = [];

window.addEventListener("load", function() {
    let addBookForm = document.getElementById("addBookForm");
    initFieldFuncMap();
    addValidation();
    addBookForm.addEventListener("submit", callValidation);
});

function addValidation() {
    for (let i = 0; i < fieldFuncMap.length; i++) {
        if (fieldFuncMap[i].control.getAttribute("type") === "file") {
            fieldFuncMap[i].control.addEventListener("change", fieldFuncMap[i].handler);
        } else {
            fieldFuncMap[i].control.addEventListener("focusout", fieldFuncMap[i].handler);
        }
    }
}

function callValidation(arg) {
    for (let i = 0; i < fieldFuncMap.length; i++) {
        let el = fieldFuncMap[i];
        el.handler(el.control);
    }
    if (hasInvalid()) {
        arg.preventDefault();
    }
}

function hasInvalid() {
    let invalidInput = document.getElementsByClassName("is-invalid");
    return invalidInput.length !== 0;
}

function initFieldFuncMap() {
    associateFuncToField("bookName", validateInput);
    associateFuncToField("originalBookName", validateInput);
    associateFuncToField("bookGenres", validateSelect);
    associateFuncToField("bookAuthors", validateSelect);
    associateFuncToField("bookCost", validateBookCost);
    associateFuncToField("bookCostPerDay", validateBookCost);
    associateFuncToField("bookYearOfPublishing", validateYearOfPublishing);
    associateFuncToField("bookNumberOfPages", validateInt);
    associateFuncToField("bookNumberOfCopies", validateInt);
    associateFuncToField("bookImages", validateImage);
}

function associateFuncToField(fieldId, func) {
    let input = document.getElementById(fieldId);
    fieldFuncMap.push({fieldName: fieldId, control: input, handler: () => func(input)})
}

function validateImage(input) {
    let value = input.value.toLowerCase();
    let exec = value.split('.').pop();
    let validSize = 2097152;
    let isValidSize = false;
    let inputFiles = input.files;

    if (exec == "jpg" || exec == "jpeg" || exec == "png") {
        for (let i = 0; i < inputFiles.length; i++) {
            isValidSize = inputFiles[i].size <= validSize;
        }
    }
    validation(isValidSize, input);
}

function validateInput(input) {
    validation(!isEmptyInput(input), input);
}

function validateSelect(select) {
    validation(!isEmptySelect(select), select);
}

function validateBookCost(costInput) {
    let regexp = /^\d+[.,]?\d*$/;
    compareInputWithPatter(costInput, regexp);
}

function validateInt(input) {
    let regexp = /^\d+$/;
    compareInputWithPatter(input, regexp);
}

function validateYearOfPublishing(yearOfPublishingInput) {
    let regexp = /^\d{4}$/;
    let currentYear = new Date().getFullYear().toString();

    if (yearOfPublishingInput.value > currentYear) {
        setInvalid(yearOfPublishingInput);
    } else {
        compareInputWithPatter(yearOfPublishingInput, regexp);
    }
}

function validation(condition, input) {
    if (condition) {
        setValid(input);
    } else {
        setInvalid(input);
    }
}

function isEmptySelect(select) {
    return getSelectedOptions(select).length === 0;
}

function getSelectedOptions(select) {
    let selected = [...select.options]
        .filter(option => option.selected)
        .map(option => option.value);
    return selected;
}

function isEmptyInput(input) {
    return input.value === "";
}

function compareInputWithPatter(input, pattern) {
    if (pattern.test(input.value)) {
        setValid(input);
    } else {
        setInvalid(input);
    }
}

function setValid(input) {
    input.classList.add("is-valid");
    input.classList.remove("is-invalid");
}

function setInvalid(input) {
    input.classList.add("is-invalid");
    input.classList.remove("is-valid");
}