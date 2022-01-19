<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addBookConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddBookJspConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.JspConsts"/>

<!DOCTYPE html>
<html>
<head>
    <title>${addBookConsts.TITLE}</title>
    <jsp:include page="head.jsp"/>
    <script src="${pageContext.request.contextPath}/js/validationAddBookForm.jsp"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>${addBookConsts.MAIN_HEADER}</h1>
<form action="process-add-book" method="post" id="addBookForm" class="needs-validation" enctype="multipart/form-data" novalidate>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_NAME_ID}">${addBookConsts.BOOK_NAME_LABEL}</label>
        <input value="1" type="text" class="form-control" id="${addBookConsts.BOOK_NAME_ID}" name="${addBookConsts.BOOK_NAME_ID}" required placeholder="${addBookConsts.BOOK_NAME_PLACEHOLDER}">
        <div id="bookNameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookNameInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.ORIGINAL_BOOK_NAME_ID}">${addBookConsts.ORIGINAL_BOOK_NAME_LABEL}</label>
        <input value="1" type="text" class="form-control" id="${addBookConsts.ORIGINAL_BOOK_NAME_ID}" name="${addBookConsts.ORIGINAL_BOOK_NAME_ID}" required placeholder="${addBookConsts.ORIGINAL_BOOK_NAME_PLACEHOLDER}">
        <div id="originalBookNameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="originalBookNameInvalidFeedBack" class="invalid-feedback">${addBookConsts.ORIGINAL_BOOK_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.GENRES_ID}">${addBookConsts.GENRES_LABEL}</label>
        <select multiple class="form-control" id="${addBookConsts.GENRES_ID}" name="${addBookConsts.GENRES_ID}" required>
            <c:forEach var="genre" items="${genres}">
                <option>${genre}</option>
            </c:forEach>
        </select>
        <div id="bookGenresValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookGenresInvalidFeedBack" class="invalid-feedback">${addBookConsts.GENRES_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.AUTHORS_ID}">${addBookConsts.AUTHORS_LABEL}</label>
        <select multiple class="form-control" id="${addBookConsts.AUTHORS_ID}" name="${addBookConsts.AUTHORS_ID}" required>
            <c:forEach var="author" items="${authors}">
                <option>${author}</option>
            </c:forEach>
            <option selected value="addNewAuthor"><a href="add-author">${addBookConsts.AUTHORS_ADD_NEW_OPTION}</a></option>
        </select>
        <div id="bookAuthorsValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookAuthorsInvalidFeedBack" class="invalid-feedback">${addBookConsts.AUTHORS_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_COST_ID}">${addBookConsts.BOOK_COST_LABEL}</label>
        <input value="1" type="text" pattern="${addBookConsts.COST_PATTERN}" class="form-control" id="${addBookConsts.BOOK_COST_ID}"
               name="${addBookConsts.BOOK_COST_ID}" required placeholder="${addBookConsts.BOOK_COST_PLACEHOLDER}" aria-describedby="bookCostHelpBlock">
        <small id="bookCostHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK}</small>
        <div id="bookCostValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookCostInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_COST_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_COST_PER_DAY_ID}">${addBookConsts.BOOK_COST_PER_DAY_LABEL}</label>
        <input value="1" type="text" pattern="${addBookConsts.COST_PATTERN}" class="form-control" id="${addBookConsts.BOOK_COST_PER_DAY_ID}"
               name="${addBookConsts.BOOK_COST_PER_DAY_ID}" required placeholder="${addBookConsts.BOOK_COST_PER_DAY_PLACEHOLDER}">
        <small id="bookCostPerDayHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK}</small>
        <div id="bookCostPerDayValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookCostPerDayInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_COST_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_ID}">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_LABEL}</label>
        <input value="2020" type="text" pattern="[0-9]{4}" class="form-control" id="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_ID}"
               name="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_ID}" required placeholder="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_PLACEHOLDER}">
        <div id="bookYearOfPublishingValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookYearOfPublishingInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_NUMBER_OF_PAGES_ID}">${addBookConsts.BOOK_NUMBER_OF_PAGES_LABEL}</label>
        <input value="1" type="number" class="form-control" id="${addBookConsts.BOOK_NUMBER_OF_PAGES_ID}"
               name="${addBookConsts.BOOK_NUMBER_OF_PAGES_ID}" required placeholder="${addBookConsts.BOOK_NUMBER_OF_PAGES_PLACEHOLDER}">
        <div id="bookNumberOfPagesValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookNumberOfPagesInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_NUMBER_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_NUMBER_OF_COPIES_ID}">${addBookConsts.BOOK_NUMBER_OF_COPIES_LABEL}</label>
        <input value="1" type="number" class="form-control" id="${addBookConsts.BOOK_NUMBER_OF_COPIES_ID}"
               name="${addBookConsts.BOOK_NUMBER_OF_COPIES_ID}" required placeholder="${addBookConsts.BOOK_NUMBER_OF_COPIES_PLACEHOLDER}">
        <div id="bookNumberOfCopiesValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookNumberOfCopiesInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_NUMBER_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_DATE_OF_REGISTRATION_ID}">${addBookConsts.BOOK_DATE_OF_REGISTRATION_LABEL}</label>
        <input type="date" class="form-control" id="${addBookConsts.BOOK_DATE_OF_REGISTRATION_ID}"
               name="${addBookConsts.BOOK_DATE_OF_REGISTRATION_ID}" required placeholder="${addBookConsts.BOOK_DATE_OF_REGISTRATION_PLACEHOLDER}">
        <div id="bookRegistrationDateValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookRegistrationDateInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_DATE_OF_REGISTRATION_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="${addBookConsts.BOOK_IMAGE_ID}">${addBookConsts.BOOK_IMAGE_LABEL}</label>
        <input type="file" class="form-control-file" id="${addBookConsts.BOOK_IMAGE_ID}"
               name="${addBookConsts.BOOK_IMAGE_ID}" required multiple accept="image/jpg, image/jpeg, image/png">
        <small id="bookImageHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_IMAGE_HELP_BLOCK}</small>
        <div id="bookImageValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookImageInvalidFeedBack" class="invalid-feedback">${addBookConsts.BOOK_IMAGE_INVALID_FEEDBACK}</div>
    </div>
    <button type="submit" class="btn btn-primary" name="submit">${jspConsts.BTN_SUBMIT}</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
