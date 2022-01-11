<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addAuthorConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddAuthorJspConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.JspConsts"/>
<!DOCTYPE html>
<html>
<head>
    <title>${addAuthorConsts.TITLE}</title>
    <jsp:include page="head.jsp"/>
    <script src="js/validationAddAuthorForm.js"></script>
    <script></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>${addAuthorConsts.MAIN_HEADER}</h1>
<form action="" method="post" id="addAuthorForm" class="needs-validation" novalidate>
    <div class="form-group">
        <label for="authorName">${addAuthorConsts.AUTHOR_NAME_LABEL}</label>
        <input type="text" class="form-control" id="authorName" required placeholder="${addAuthorConsts.AUTHOR_NAME_PLACEHOLDER}">
        <div id="authorNameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="authorNameInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="authorSurname">${addAuthorConsts.AUTHOR_NAME_LABEL}</label>
        <input type="text" class="form-control" id="authorSurname" required placeholder="${addAuthorConsts.AUTHOR_NAME_PLACEHOLDER}">
        <div id="authorSurnameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="authorSurnameInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_NAME_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <div class="custom-control custom-switch">
            <input id="isPatronymicExist" type="checkbox" class="custom-control-input">
            <label class="custom-control-label" for="isPatronymicExist">${addAuthorConsts.AUTHOR_PATRONYMIC_SWITCH_LABEL}</label>
        </div>
        <label for="authorPatronymic">${addAuthorConsts.AUTHOR_PATRONYMIC_LABEL}</label>
        <input type="text" class="form-control" id="authorPatronymic" required placeholder="${addAuthorConsts.AUTHOR_PATRONYMIC_PLACEHOLDER}">
        <div id="authorPatronymicValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="authorPatronymicInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_PATRONYMIC_INVALID_FEEDBACK}</div>
    </div>
    <div class="form-group">
        <label for="bookImage">${addBookConsts.AUTHOR_IMAGE_LABEL}</label>
        <input type="file" class="form-control-file" id="bookImage" required multiple accept="image/jpg, image/jpeg, image/png">
        <small id="bookImageHelpBlock" class="form-text text-muted">${addBookConsts.AUTHOR_IMAGE_HELP_BLOCK}</small>
        <div id="bookImageValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>
        <div id="bookImageInvalidFeedBack" class="invalid-feedback">${addBookConsts.AUTHOR_IMAGE_INVALID_FEEDBACK}</div>
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
