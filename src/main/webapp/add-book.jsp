<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addBookConsts" class="com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.jsp.AddBookJspConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.jsp.JspConsts"/>
<!DOCTYPE html>
<html>
<head>
    <title>${addBookConsts.TITLE}</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>${addBookConsts.MAIN_HEADER}</h1>
<form method="post">
    <div class="form-group">
        <label for="bookName">${addBookConsts.BOOK_NAME_LABEL}</label>
        <input type="text" class="form-control" id="bookName" required="required" placeholder=${addBookConsts.BOOK_NAME_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="originalBookName">${addBookConsts.ORIGINAL_BOOK_NAME_LABEL}</label>
        <input type="text" class="form-control" id="originalBookName" required="required" placeholder=${addBookConsts.ORIGINAL_BOOK_NAME_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.ORIGINAL_BOOK_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookGenres">${addBookConsts.GENRES_LABEL}</label>
        <select multiple class="form-control" id="bookGenres" required="required">
            <c:forEach var="genre" items="${genres}">
                <option>${genre}</option>
            </c:forEach>
            <option value="addNewGenre"><a href="add-genre">${addBookConsts.GENRES_ADD_NEW_OPTION}</a></option>
        </select>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.GENRES_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookAuthors">${addBookConsts.AUTHORS_LABEL}</label>
        <select multiple class="form-control" id="bookAuthors">
            <c:forEach var="author" items="${authors}">
                <option>${author}</option>
            </c:forEach>
            <option value="addNewAuthor"><a href="add-author">${addBookConsts.AUTHORS_ADD_NEW_OPTION}</a></option>
        </select>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.AUTHORS_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookCost">${addBookConsts.BOOK_COST_LABEL}</label>
        <input type="text" pattern="[0-9]*[.]{1}[0-9]*" class="form-control" id="bookCost" required="required" placeholder=${addBookConsts.BOOK_COST_PLACEHOLDER} aria-describedby="bookCostHelpBlock">
        <small id="bookCostHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK}</small>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_COST_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookCostPerDay">${addBookConsts.BOOK_COST_PER_DAY_LABEL}</label>
        <input type="text" pattern=${jspConsts.COST_PATTERN} class="form-control" id="bookCostPerDay" required="required" placeholder=${addBookConsts.BOOK_COST_PER_DAY_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_COST_PER_DAY_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="yearOfPublishing">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_LABEL}</label>
        <input type="text" pattern="[0-9]{4}" class="form-control" id="yearOfPublishing" required="required" placeholder=${addBookConsts.BOOK_YEAR_OF_PUBLISHING_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="numberOfPages">${addBookConsts.BOOK_NUMBER_OF_COPIES_LABEL}</label>
        <input type="number" class="form-control" id="numberOfPages" required="required" placeholder=${addBookConsts.BOOK_NUMBER_OF_COPIES_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_NUMBER_OF_COPIES_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="numberOfCopies">${addBookConsts.BOOK_NUMBER_OF_COPIES_LABEL}</label>
        <input type="number" class="form-control" id="numberOfCopies" required="required" placeholder=${addBookConsts.BOOK_NUMBER_OF_COPIES_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_NUMBER_OF_COPIES_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="registrationDate">${addBookConsts.BOOK_DATE_OF_REGISTRATION_LABEL}</label>
        <input type="datetime-local" class="form-control" id="registrationDate" required="required" placeholder=${addBookConsts.BOOK_DATE_OF_REGISTRATION_PLACEHOLDER}>
        <div class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div class="invalid-feedback">${addBookConsts.BOOK_DATE_OF_REGISTRATION_INVALID_FEEDBACK}</div>
    </div>
    <button type="submit" class="btn btn-primary">${jspConsts.BTN_SUBMIT}</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
