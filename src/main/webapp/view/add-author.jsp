<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addAuthorConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddAuthorConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.MainConsts"/>
<!DOCTYPE html>
<html>
<head>
    <title>${addAuthorConsts.TITLE()}</title>
    <jsp:include page="head.jsp"/>
    <script src="../static/js/add-author-form-validation.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 class="bg-light p-3 rounded">${addAuthorConsts.MAIN_HEADER()}</h2>

<form action="add-author-processing" method="post" id="addAuthorForm" class="needs-validation" novalidate>
    <div class="form-row my-3">
        <div class="form-group col">
            <label for="${addAuthorConsts.AUTHOR_NAME_ID()}">${addAuthorConsts.AUTHOR_NAME_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addAuthorConsts.AUTHOR_NAME_ID()}" name="${addAuthorConsts.AUTHOR_NAME_ID()}" placeholder="${addAuthorConsts.AUTHOR_NAME_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addAuthorConsts.AUTHOR_NAME_INVALID_FEEDBACK()}</div>
        </div>
        <div class="form-group col">
            <label for="${addAuthorConsts.AUTHOR_NAME_ID()}">${addAuthorConsts.AUTHOR_NAME_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addAuthorConsts.AUTHOR_NAME_ID()}" name="${addAuthorConsts.AUTHOR_NAME_ID()}" placeholder="${addAuthorConsts.AUTHOR_NAME_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addAuthorConsts.AUTHOR_NAME_INVALID_FEEDBACK()}</div>
        </div>
    </div>
    <div class="form-group my-3">
        <div class="custom-control custom-switch my-2">
            <input id="isPatronymicExist" type="checkbox" class="custom-control-input">
            <label class="custom-control-label" for="isPatronymicExist">${addAuthorConsts.AUTHOR_PATRONYMIC_SWITCH_LABEL()}</label>
        </div>
        <input type="text" class="form-control" id="authorPatronymic" required placeholder="${addAuthorConsts.AUTHOR_PATRONYMIC_PLACEHOLDER()}">
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addAuthorConsts.AUTHOR_PATRONYMIC_INVALID_FEEDBACK()}</div>
    </div>
    <button type="submit" class="btn btn-dark" name="submit">${jspConsts.BTN_SUBMIT()}</button>
</form>



<%--<form action="" method="post" id="addAuthorForm" class="needs-validation" novalidate>--%>
<%--    <div class="form-group">--%>
<%--        <label for="authorName">${addAuthorConsts.AUTHOR_NAME_LABEL}</label>--%>
<%--        <input type="text" class="form-control" id="authorName" required placeholder="${addAuthorConsts.AUTHOR_NAME_PLACEHOLDER}">--%>
<%--        <div id="authorNameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>--%>
<%--        <div id="authorNameInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_NAME_INVALID_FEEDBACK}</div>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="authorSurname">${addAuthorConsts.AUTHOR_NAME_LABEL}</label>--%>
<%--        <input type="text" class="form-control" id="authorSurname" required placeholder="${addAuthorConsts.AUTHOR_NAME_PLACEHOLDER}">--%>
<%--        <div id="authorSurnameValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>--%>
<%--        <div id="authorSurnameInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_NAME_INVALID_FEEDBACK}</div>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <div class="custom-control custom-switch">--%>
<%--            <input id="isPatronymicExist" type="checkbox" class="custom-control-input">--%>
<%--            <label class="custom-control-label" for="isPatronymicExist">${addAuthorConsts.AUTHOR_PATRONYMIC_SWITCH_LABEL}</label>--%>
<%--        </div>--%>
<%--        <label for="authorPatronymic">${addAuthorConsts.AUTHOR_PATRONYMIC_LABEL}</label>--%>
<%--        <input type="text" class="form-control" id="authorPatronymic" required placeholder="${addAuthorConsts.AUTHOR_PATRONYMIC_PLACEHOLDER}">--%>
<%--        <div id="authorPatronymicValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>--%>
<%--        <div id="authorPatronymicInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_PATRONYMIC_INVALID_FEEDBACK}</div>--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label for="bookImage">${addAuthorConsts.AUTHOR_IMAGE_LABEL}</label>--%>
<%--        <input type="file" class="form-control-file" id="bookImage" required multiple accept="image/jpg, image/jpeg, image/png">--%>
<%--        <small id="bookImageHelpBlock" class="form-text text-muted">${addAuthorConsts.AUTHOR_IMAGE_HELP_BLOCK}</small>--%>
<%--        <div id="bookImageValidFeedBack" class="valid-feedback">${jspConsts.VALID_FEEDBACK}</div>--%>
<%--        <div id="bookImageInvalidFeedBack" class="invalid-feedback">${addAuthorConsts.AUTHOR_IMAGE_INVALID_FEEDBACK}</div>--%>
<%--    </div>--%>
<%--</form>--%>
<jsp:include page="footer.jsp"/>
</body>
</html>
