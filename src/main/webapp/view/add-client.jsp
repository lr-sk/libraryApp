<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="addClientConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddClientConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.MainConsts"/>
<!DOCTYPE html>
<html>
<head>
    <title>${addClientConsts.TITLE()}</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<h2 class="bg-light p-3 rounded text-center">${addClientConsts.MAIN_HEADER()}</h2>
<form action="add-client-processing" method="post" id="addClientForm" class="needs-validation" enctype="multipart/form-data" novalidate>

    <div class="form-row my-4">
        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_NAME_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_NAME_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_NAME_ID()}" name="${addClientConsts.CLIENT_NAME_ID()}" placeholder="${addClientConsts.CLIENT_NAME_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_NAME_INVALID_FEEDBACK()}</div>
        </div>

        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_SURNAME_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_SURNAME_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_SURNAME_ID()}" name="${addClientConsts.CLIENT_SURNAME_ID()}" placeholder="${addClientConsts.CLIENT_SURNAME_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_SURNAME_INVALID_FEEDBACK()}</div>
        </div>
    </div>

    <div class="form-group my-4">
        <div class="custom-control custom-switch my-2">
            <input id="isClientPatronymicExist" type="checkbox" class="custom-control-input">
            <label class="custom-control-label font-weight-bold" for="isClientPatronymicExist">${addClientConsts.CLIENT_PATRONYMIC_SWITCH_LABEL()}</label>
        </div>
        <input type="text" class="form-control" id="authorPatronymic" required placeholder="${addClientConsts.CLIENT_PATRONYMIC_PLACEHOLDER()}">
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_PATRONYMIC_INVALID_FEEDBACK()}</div>
    </div>

    <div class="form-group my-4">
        <label for="${addClientConsts.CLIENT_PASSPORT_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_PASSPORT_LABEL()}</label>
        <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_PASSPORT_ID()}" name="${addClientConsts.CLIENT_PASSPORT_ID()}" placeholder="${addClientConsts.CLIENT_PASSPORT_PLACEHOLDER()}">
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_PASSPORT_INVALID_FEEDBACK()}</div>
    </div>

    <div class="form-group my-4">
        <label for="${addClientConsts.DATE_OF_BIRTH_ID()}" class="font-weight-bold">${addClientConsts.DATE_OF_BIRTH_LABEL()}</label>
        <input value="" type="date" class="form-control" id="${addClientConsts.DATE_OF_BIRTH_ID()}"
               name="${addClientConsts.DATE_OF_BIRTH_ID()}">
    </div>

    <div class="form-group my-4">
        <label for="${addClientConsts.CLIENT_EMAIL_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_EMAIL_LABEL()}</label>
        <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_EMAIL_ID()}" name="${addClientConsts.CLIENT_EMAIL_ID()}" placeholder="${addClientConsts.CLIENT_EMAIL_PLACEHOLDER()}">
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_EMAIL_INVALID_FEEDBACK()}</div>
    </div>

    <div class="form-row my-4">
        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_ADDRESS_CITY_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_ADDRESS_CITY_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_ADDRESS_CITY_ID()}" name="${addClientConsts.CLIENT_ADDRESS_CITY_ID()}" placeholder="${addClientConsts.CLIENT_ADDRESS_CITY_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_ADDRESS_CITY_INVALID_FEEDBACK()}</div>
        </div>

        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_ADDRESS_ZIPCODE_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_ADDRESS_ZIPCODE_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_ADDRESS_ZIPCODE_ID()}" name="${addClientConsts.CLIENT_ADDRESS_ZIPCODE_ID()}" placeholder="${addClientConsts.CLIENT_ADDRESS_ZIPCODE_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_ADDRESS_ZIPCODE_INVALID_FEEDBACK()}</div>
        </div>
        
    </div>

    <div class="form-row my-4">
        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_ADDRESS_STREET_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_ADDRESS_STREET_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_ADDRESS_STREET_ID()}" name="${addClientConsts.CLIENT_ADDRESS_STREET_ID()}" placeholder="${addClientConsts.CLIENT_ADDRESS_STREET_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_ADDRESS_STREET_INVALID_FEEDBACK()}</div>
        </div>

        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_ADDRESS_HOUSE_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_ADDRESS_HOUSE_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_ADDRESS_HOUSE_ID()}" name="${addClientConsts.CLIENT_ADDRESS_HOUSE_ID()}" placeholder="${addClientConsts.CLIENT_ADDRESS_HOUSE_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_ADDRESS_HOUSE_INVALID_FEEDBACK()}</div>
        </div>

        <div class="form-group col">
            <label for="${addClientConsts.CLIENT_ADDRESS_APARTMENT_ID()}" class="font-weight-bold">${addClientConsts.CLIENT_ADDRESS_APARTMENT_LABEL()}</label>
            <input value="" type="text" class="form-control" id="${addClientConsts.CLIENT_ADDRESS_APARTMENT_ID()}" name="${addClientConsts.CLIENT_ADDRESS_APARTMENT_ID()}" placeholder="${addClientConsts.CLIENT_ADDRESS_APARTMENT_PLACEHOLDER()}">
            <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
            <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addClientConsts.CLIENT_ADDRESS_APARTMENT_INVALID_FEEDBACK()}</div>
        </div>

    </div>
    

</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
