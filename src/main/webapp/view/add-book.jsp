<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="addBookConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddBookConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.MainConsts"/>

<!DOCTYPE html>
<html>
<head>
    <title>${addBookConsts.TITLE()}</title>
    <jsp:include page="head.jsp"/>
    <script src="../static/js/add-book-form-validation.js"></script>
    <script src="../static/js/add-book-page-handler.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 class="bg-light p-3 rounded text-center">${addBookConsts.MAIN_HEADER()}</h2>
<c:if test="${not empty isCreated}">
    <c:choose>
        <c:when test="${isCreated}">
            <i>Yes</i>
        </c:when>
        <c:otherwise>
            <i>No</i>
        </c:otherwise>
    </c:choose>
</c:if>
<form action="add-book-processing" method="post" id="addBookForm" class="needs-validation" enctype="multipart/form-data" novalidate>

    <div class="form-row my-3">
        <div class="form-group col">
            <label for="${addBookConsts.BOOK_NAME_ID()}" class="font-weight-bold">${addBookConsts.BOOK_NAME_LABEL()}</label>
            <c:choose>
                <c:when test="${existingBookName}">
                    <input value="<c:out value="${name}"/>"
                           type="text" class="form-control is-invalid" id="${addBookConsts.BOOK_NAME_ID()}" name="${addBookConsts.BOOK_NAME_ID()}">
                    <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
                    <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_NAME_INVALID_FEEDBACK()}</div>
                </c:when>
                <c:otherwise>
                    <input value="" type="text" class="form-control" id="${addBookConsts.BOOK_NAME_ID()}" name="${addBookConsts.BOOK_NAME_ID()}" placeholder="${addBookConsts.BOOK_NAME_PLACEHOLDER()}">
                    <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
                    <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_NAME_INVALID_FEEDBACK()}</div>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="form-group col">
            <label for="${addBookConsts.ORIGINAL_BOOK_NAME_ID()}" class="font-weight-bold">${addBookConsts.ORIGINAL_BOOK_NAME_LABEL()}</label>
            <c:choose>
                <c:when test="${existingOriginalBookName}">
                    <input value="<c:out value="${originalName}"/>"
                           type="text" class="form-control is-invalid" id="${addBookConsts.ORIGINAL_BOOK_NAME_ID()}" name="${addBookConsts.ORIGINAL_BOOK_NAME_ID()}">
                    <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
                    <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.ORIGINAL_BOOK_NAME_INVALID_FEEDBACK()}</div>
                </c:when>
                <c:otherwise>
                    <input value="" type="text" class="form-control" id="${addBookConsts.ORIGINAL_BOOK_NAME_ID()}" name="${addBookConsts.ORIGINAL_BOOK_NAME_ID()}" placeholder="${addBookConsts.ORIGINAL_BOOK_NAME_PLACEHOLDER()}">
                    <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
                    <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.ORIGINAL_BOOK_NAME_INVALID_FEEDBACK()}</div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="form-group my-4">
        <label for="${addBookConsts.GENRES_ID()}" class="font-weight-bold">${addBookConsts.GENRES_LABEL()}</label>
        <select multiple class="form-control" id="${addBookConsts.GENRES_ID()}" name="${addBookConsts.GENRES_ID()}">
            <c:forEach var="genre" items="${genres}">
                <option id="${genre.getId()}" value="${genre.getId()}">${genre.getName()}</option>
            </c:forEach>
            <%--            <c:choose>--%>
            <%--                <c:when test="${not empty failed}">--%>
            <%--                    <c:forEach var="genre" items="${genres}">--%>
            <%--                        <c:forEach var="selectedGenre" items="${selectedGenres}">--%>
            <%--                            <c:choose>--%>
            <%--                                <c:when test="${genre.getId() == selectedGenre}">--%>
            <%--                                    <option selected value="${genre.getId()}">${genre.getName()}</option>--%>
            <%--                                </c:when>--%>
            <%--                                <c:otherwise>--%>
            <%--                                    <option value="${genre.getId()}">${genre.getName()}</option>--%>
            <%--                                </c:otherwise></c:choose>--%>
            <%--                        </c:forEach>--%>
            <%--                    </c:forEach>--%>
            <%--                </c:when>--%>
            <%--                <c:otherwise>--%>
            <%--                    <c:forEach var="genre" items="${genres}">--%>
            <%--                        <option value="${genre.getId()}">${genre.getName()}</option>--%>
            <%--                    </c:forEach>--%>
            <%--                </c:otherwise>--%>
            <%--            </c:choose>--%>
        </select>
<%--        <p class="badges my-3">--%>
<%--            <a href="#" class="badge badge-dark">1111</a>--%>
<%--            <a href="#" class="badge badge-dark">2222</a>--%>
<%--            <a href="#" class="badge badge-dark">3333</a>--%>
<%--        </p>--%>
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.GENRES_INVALID_FEEDBACK()}</div>
    </div>
    <div class="form-group my-4">
        <label for="${addBookConsts.AUTHORS_ID()}" class="font-weight-bold">${addBookConsts.AUTHORS_LABEL()}</label>
        <select class="form-control" id="${addBookConsts.AUTHORS_ID()}" name="${addBookConsts.AUTHORS_ID()}" multiple>
            <c:forEach var="author" items="${authors}">
                <option id="${author.getId()}" value="${author.getId()}">${author.getFullName()}</option>
            </c:forEach>
        </select>
        <div><a href="add-author" class="btn btn-link btn-sm text-info">${addBookConsts.AUTHORS_ADD_NEW_OPTION()}</a></div>
<%--        <p id="${addBookConsts.SELECTED_AUTHORS_BLOCK()} my-3" class="badges">--%>
<%--            <a href="#" class="badge badge-dark">1111</a>--%>
<%--            <a href="#" class="badge badge-dark">2222</a>--%>
<%--            <a href="#" class="badge badge-dark">3333</a>--%>
<%--        </p>--%>
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.AUTHORS_INVALID_FEEDBACK()}</div>
    </div>

    <div class="form-group my-4">
        <label for="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_ID()}" class="font-weight-bold" class="font-weight-bold">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_LABEL()}</label>
        <input value="<c:if test="${not empty failed}">${year}</c:if>" type="text" class="form-control" id="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_ID()}"
               name="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_ID()}" placeholder="${addBookConsts.BOOK_YEAR_OF_PUBLISHING_PLACEHOLDER()}">
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_YEAR_OF_PUBLISHING_INVALID_FEEDBACK()}</div>
    </div>
    <div class="form-row my-4">
        <div class="form-group col">
            <label for="${addBookConsts.BOOK_NUMBER_OF_PAGES_ID()}" class="font-weight-bold">${addBookConsts.BOOK_NUMBER_OF_PAGES_LABEL()}</label>
            <input value="<c:if test="${not empty failed}">${pages}</c:if>" type="number" class="form-control" id="${addBookConsts.BOOK_NUMBER_OF_PAGES_ID()}"
                   name="${addBookConsts.BOOK_NUMBER_OF_PAGES_ID()}" placeholder="${addBookConsts.BOOK_NUMBER_OF_PAGES_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_NUMBER_INVALID_FEEDBACK()}</div>
        </div>
        <div class="form-group col">
            <label for="${addBookConsts.BOOK_NUMBER_OF_COPIES_ID()}" class="font-weight-bold">${addBookConsts.BOOK_NUMBER_OF_COPIES_LABEL()}</label>
            <input value="<c:if test="${not empty failed}">${copies}</c:if>" type="number" class="form-control" id="${addBookConsts.BOOK_NUMBER_OF_COPIES_ID()}"
                   name="${addBookConsts.BOOK_NUMBER_OF_COPIES_ID()}" placeholder="${addBookConsts.BOOK_NUMBER_OF_COPIES_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_NUMBER_INVALID_FEEDBACK()}</div>
        </div>
    </div>

    <div class="form-row my-4">
        <div class="form-group col">
            <label for="${addBookConsts.BOOK_COST_ID()}" class="font-weight-bold">${addBookConsts.BOOK_COST_LABEL()}</label>
            <input value="<c:if test="${not empty failed}">${cost}</c:if>" type="text" pattern="${addBookConsts.COST_PATTERN()}" class="form-control" id="${addBookConsts.BOOK_COST_ID()}"
                   name="${addBookConsts.BOOK_COST_ID()}" placeholder="${addBookConsts.BOOK_COST_PLACEHOLDER()}" aria-describedby="bookCostHelpBlock">
            <small id="bookCostHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK()}</small>
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_COST_INVALID_FEEDBACK()}</div>
        </div>
        <div class="form-group col">
            <label for="${addBookConsts.BOOK_COST_PER_DAY_ID()}" class="font-weight-bold">${addBookConsts.BOOK_COST_PER_DAY_LABEL()}</label>
            <input value="<c:if test="${not empty failed}">${costPerDay}</c:if>" type="text" class="form-control" id="${addBookConsts.BOOK_COST_PER_DAY_ID()}"
                   name="${addBookConsts.BOOK_COST_PER_DAY_ID()}" placeholder="${addBookConsts.BOOK_COST_PER_DAY_PLACEHOLDER()}">
            <small id="bookCostPerDayHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_COST_HELP_BLOCK()}</small>
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_COST_INVALID_FEEDBACK()}</div>
        </div>
    </div>

    <div class="form-group my-4">
        <label for="${addBookConsts.BOOK_IMAGE_ID()}" class="font-weight-bold">${addBookConsts.BOOK_IMAGE_LABEL()}</label>
        <input type="file" class="form-control-file" id="${addBookConsts.BOOK_IMAGE_ID()}"
               name="${addBookConsts.BOOK_IMAGE_ID()}" multiple accept="image/jpg, image/jpeg, image/png">
        <small id="bookImageHelpBlock" class="form-text text-muted">${addBookConsts.BOOK_IMAGE_HELP_BLOCK()}</small>
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookConsts.BOOK_IMAGE_INVALID_FEEDBACK()}</div>
    </div>
    <div class="form-group my-4">
        <label for="${addBookConsts.BOOK_DATE_OF_REGISTRATION_ID()}" class="font-weight-bold">${addBookConsts.BOOK_DATE_OF_REGISTRATION_LABEL()}</label>
        <input value="" type="date" class="form-control" id="${addBookConsts.BOOK_DATE_OF_REGISTRATION_ID()}"
               name="${addBookConsts.BOOK_DATE_OF_REGISTRATION_ID()}" readonly>
    </div>

    <button type="submit" class="btn btn-info" name="submit">${jspConsts.BTN_SUBMIT()}</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
