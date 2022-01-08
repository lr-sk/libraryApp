<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addBookConsts" class="com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.jsp.AddBookJspConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.jsp.JspConsts"/>

<!DOCTYPE html>
<html>
<head>
    <title>${addBookConsts.TITLE}</title>
    <jsp:include page="head.jsp"/>
    <script src="js/validationAddBookForm.js"></script>
    <script>
        window.addEventListener("load", function() {
            let bookNameInput = document.getElementById("bookName");
            let originalBookNameInput = document.getElementById("originalBookName");
            let bookGenresSelect = document.getElementById("bookGenres");
            let bookAuthorsSelect = document.getElementById("bookAuthors");
            let bookCostInput = document.getElementById("bookCost");
            let bookCostPerDayInput = document.getElementById("bookCostPerDay");
            let bookYearOfPublishingInput = document.getElementById("bookYearOfPublishing");
            let bookNumberOfPagesInput = document.getElementById("bookNumberOfPages");
            let bookNumberOfCopiesInput = document.getElementById("bookNumberOfCopies");
            let bookRegistrationDateInput = document.getElementById("bookRegistrationDate");

            bookNameInput.addEventListener("focusout", () => {});
            originalBookNameInput.addEventListener("focusout", () => {});
            bookGenresSelect.addEventListener("focusout", () => {});
            bookAuthorsSelect.addEventListener("focusout", () => {});
            bookCostInput.addEventListener("focusout", () => {validateBookCost(bookCostInput)});
            bookCostPerDayInput.addEventListener("focusout", () => {validateBookCost(bookCostPerDayInput)});
            bookYearOfPublishingInput.addEventListener("focusout", () => {validateYearOfPublishing(bookYearOfPublishingInput)});
            bookNumberOfPagesInput.addEventListener("focusout", () => {validateInt(bookNumberOfPagesInput)});
            bookNumberOfCopiesInput.addEventListener("focusout", () => {validateInt(bookNumberOfCopiesInput)});
            bookRegistrationDateInput.addEventListener("focusout", () => validateDate(bookRegistrationDateInput));
        });

        function isEmpty(value) {
            return value === "";
        }

        function setValid(inputValue) {
            inputValue.classList.add("is-valid");
            inputValue.classList.remove("is-invalid");
        }

        function setInvalid(inputValue) {
            inputValue.classList.add("is-invalid");
            inputValue.classList.remove("is-valid");
        }

        function validateInt(inputValue) {
            let regexp = /^d+$/;
            compareInputWithPatter(inputValue, regexp);
        }

        function compareInputWithPatter(input, pattern) {
            let value = input.value;

            if (!isEmpty(value)) {
                if (pattern.test(value)) {
                    setValid(input);
                } else {
                    setInvalid(input);
                }
            } else {
                setInvalid(input);
            }

            // if (pattern.test(value)) {
            //     setValid(input);
            // } else {
            //     setInvalid(input);
            // }
        }

        function validateBookCost(costInput) {
            let regexp = /^\d+[.,]?\d*$/;

            compareInputWithPatter(costInput, regexp);
        }

        function validateYearOfPublishing(yearOfPublishingInput) {
            let yearOfPublishingInputValue = yearOfPublishingInput.value;
            let regexp = /^\d{4}$/;
            let currentYear = new Date().getFullYear().toString();

            if (yearOfPublishingInputValue > currentYear) {
                setInvalid(yearOfPublishingInput);
            } else {
                compareInputWithPatter(yearOfPublishingInput, regexp);
            }
        }

        function validateDate(dateInput){
            let dateInputValue = dateInput.value;

            if (!isEmpty(dateInputValue)) {
                if (Date.parse(dateInputValue) < Date.now()) {
                    setValid(dateInput);
                } else {
                    setInvalid(dateInput);
                }
            } else {
                setInvalid(dateInput);
            }
        }
    </script>

</head>
<body>
<jsp:include page="header.jsp"/>
<h1>${addBookConsts.MAIN_HEADER}</h1>
<form method="post" id="addBookForm" class="needs-validation">
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
            <option value="addNewGenre"><a href="add-genre">${addBookConsts.GENRES_ADD_NEW_OPTION}</a></option>
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
        <input type="text" pattern="[0-9]*[.]{1}[0-9]*" class="form-control" id="bookCost" required placeholder="${addBookConsts.BOOK_COST_PLACEHOLDER}" aria-describedby="bookCostHelpBlock">
        <small id="bookCostHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK}</small>
        <div id="bookCostValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookCostInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_COST_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookCostPerDay">${addBookConsts.BOOK_COST_PER_DAY_LABEL}</label>
        <input type="text" pattern=${addBookConsts.COST_PATTERN} class="form-control" id="bookCostPerDay" required placeholder="${addBookConsts.BOOK_COST_PER_DAY_PLACEHOLDER}">
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
        <input type="file" class="form-control-file" id="bookImage" required multiple accept="image/*" placeholder="gfgfg">
        <small id="bookImageHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_IMAGE_HELP_BLOCK}</small>
        <div id="bookImageValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookImageInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_IMAGE_INVALID_FEEDBACK}</div>
    </div>
    <button type="submit" class="btn btn-primary">${jspConsts.BTN_SUBMIT}</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
