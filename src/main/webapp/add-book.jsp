<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addBookConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddBookJspConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.JspConsts"/>

<!DOCTYPE html>
<html>
<head>
    <title>${addBookConsts.TITLE}</title>
    <jsp:include page="head.jsp"/>
    <script src="js/validationAddBookForm.js"></script>
    <script>
        let fieldFuncMap = [];

        window.addEventListener("load", function() {
            let addBookForm = document.getElementById("addBookForm")
            initFieldFuncMap();
            addValidation();
            addBookForm.addEventListener("submit", callValidation);
        });

        function addValidation() {
            for (let i = 0; i < fieldFuncMap.length; i++) {
                fieldFuncMap[i].control.addEventListener("focusout", fieldFuncMap[i].handler);
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
            associateFuncToField("bookRegistrationDate", validateDate);
            associateFuncToField("bookImage", validateImage);
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

        function validateDate(dateInput){
            if (!isEmptyInput(dateInput)) {
                validation(Date.parse(dateInput.value) < Date.now(), dateInput);
            } else {
                setInvalid(dateInput);
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
    </script>

</head>
<body>
<jsp:include page="header.jsp"/>
<h1>${addBookConsts.MAIN_HEADER}</h1>
<form action="" method="post" id="addBookForm" class="needs-validation" enctype="multipart/form-data" novalidate>
    <div class="form-group">
        <label for="bookName">${addBookConsts.BOOK_NAME_LABEL}</label>
        <input type="text" class="form-control" id="bookName" required placeholder="${addBookConsts.BOOK_NAME_PLACEHOLDER}">
        <div id="bookNameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookNameInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="originalBookName">${addBookConsts.ORIGINAL_BOOK_NAME_LABEL}</label>
        <input type="text" class="form-control" id="originalBookName" required placeholder="${addBookConsts.ORIGINAL_BOOK_NAME_PLACEHOLDER}">
        <div id="originalBookNameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="originalBookNameInvalidFeedBack" class="invalid-feedback">${addBookConsts.ORIGINAL_BOOK_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookGenres">${addBookConsts.GENRES_LABEL}</label>
        <select multiple class="form-control" id="bookGenres" required>
            <c:forEach var="genre" items="${genres}">
                <option>${genre}</option>
            </c:forEach>
        </select>
        <div id="bookGenresValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookGenresInvalidFeedBack" class="invalid-feedback">${addBookConsts.GENRES_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookAuthors">${addBookConsts.AUTHORS_LABEL}</label>
        <select multiple class="form-control" id="bookAuthors">
            <c:forEach var="author" items="${authors}">
                <option>${author}</option>
            </c:forEach>
            <option value="addNewAuthor"><a href="add-author">${addBookConsts.AUTHORS_ADD_NEW_OPTION}</a></option>
        </select>
        <div id="bookAuthorsValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookAuthorsInvalidFeedBack" class="invalid-feedback">${addBookConsts.AUTHORS_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookCost">${addBookConsts.BOOK_COST_LABEL}</label>
        <input type="text" pattern="${addBookConsts.COST_PATTERN}" class="form-control" id="bookCost" required placeholder="${addBookConsts.BOOK_COST_PLACEHOLDER}" aria-describedby="bookCostHelpBlock">
        <small id="bookCostHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK}</small>
        <div id="bookCostValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookCostInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_COST_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookCostPerDay">${addBookConsts.BOOK_COST_PER_DAY_LABEL}</label>
        <input type="text" pattern="${addBookConsts.COST_PATTERN}" class="form-control" id="bookCostPerDay" required placeholder="${addBookConsts.BOOK_COST_PER_DAY_PLACEHOLDER}">
        <small id="bookCostPerDayHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK}</small>
        <div id="bookCostPerDayValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookCostPerDayInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_COST_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookYearOfPublishing">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_LABEL}</label>
        <input type="text" pattern="[0-9]{4}" class="form-control" id="bookYearOfPublishing" required placeholder="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_PLACEHOLDER}">
        <div id="bookYearOfPublishingValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookYearOfPublishingInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookNumberOfPages">${addBookConsts.BOOK_NUMBER_OF_PAGES_LABEL}</label>
        <input type="number" class="form-control" id="bookNumberOfPages" required placeholder="${addBookConsts.BOOK_NUMBER_OF_PAGES_PLACEHOLDER}">
        <div id="bookNumberOfPagesValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookNumberOfPagesInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_NUMBER_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookNumberOfCopies">${addBookConsts.BOOK_NUMBER_OF_COPIES_LABEL}</label>
        <input type="number" class="form-control" id="bookNumberOfCopies" required placeholder="${addBookConsts.BOOK_NUMBER_OF_COPIES_PLACEHOLDER}">
        <div id="bookNumberOfCopiesValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookNumberOfCopiesInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_NUMBER_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookRegistrationDate">${addBookConsts.BOOK_DATE_OF_REGISTRATION_LABEL}</label>
        <input type="datetime-local" class="form-control" id="bookRegistrationDate" required placeholder="${addBookConsts.BOOK_DATE_OF_REGISTRATION_PLACEHOLDER}">
        <div id="bookRegistrationDateValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookRegistrationDateInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_DATE_OF_REGISTRATION_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookImage">${addBookConsts.BOOK_IMAGE_LABEL}</label>
        <input type="file" class="form-control-file" id="bookImage" required multiple accept="image/jpg, image/jpeg, image/png">
        <small id="bookImageHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_IMAGE_HELP_BLOCK}</small>
        <div id="bookImageValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookImageInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_IMAGE_INVALID_FEEDBACK}</div>
    </div>
    <button type="submit" class="btn btn-primary">${jspConsts.BTN_SUBMIT}</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
