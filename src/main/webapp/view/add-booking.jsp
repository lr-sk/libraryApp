<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="addBookingConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddBookingConsts"/>
<jsp:useBean id="jspConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.MainConsts"/>


<!DOCTYPE html>
<html>
<head>
    <title>${addBookingConsts.TITLE()}</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 class="bg-light p-3 rounded">${addBookingConsts.MAIN_HEADER()}</h2>

<form action="add-booking-processing" method="post" id="addBookingForm" class="needs-validation" enctype="multipart/form-data" novalidate>
    
    <div class="form-group my-4">
        <label for="${addBookingConsts.CLIENT_ID()}" class="font-weight-bold">${addBookingConsts.CLIENT_LABEL()}</label>
        <select class="form-control" id="${addBookingConsts.CLIENT_ID()}" name="${addBookingConsts.CLIENT_ID()}">
<%--            <c:forEach var="book" items="${clients}">--%>
<%--                <option id="${book.getId()}" value="${book.getFullName()}">${book.getFullName()}</option>--%>
<%--            </c:forEach>--%>
        </select>
        <div><a href="add-client" class="btn btn-link btn-sm text-info">${addBookingConsts.CLIENT_ADD_NEW_OPTION()}</a></div>
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookingConsts.CLIENT_INVALID_FEEDBACK()}</div>
    </div>

    <div class="form-group my-4">
        <label for="${addBookingConsts.BOOK_ID()}" class="font-weight-bold">${addBookingConsts.BOOK_LABEL()}</label>
        <select class="form-control" id="${addBookingConsts.BOOK_ID()}" name="${addBookingConsts.BOOK_ID()}" multiple>
<%--            <c:forEach var="book" items="${books}">--%>
<%--                <option id="${book.getId()}" value="${book.getFullName()}">${book.getFullName()}</option>--%>
<%--            </c:forEach>--%>
        </select>
        <div><a href="add-book" class="btn btn-link btn-sm text-info">${addBookingConsts.BOOK_ADD_NEW_OPTION()}</a></div>
        <div class="${jspConsts.VALID_FEEDBACK_CLASS()}">${jspConsts.VALID_FEEDBACK()}</div>
        <div class="${jspConsts.INVALID_FEEDBACK_CLASS()}">${addBookingConsts.BOOK_INVALID_FEEDBACK()}</div>
    </div>

    <div class="form-row my-3">
        <div class="form-group col">
            <label for="${addBookingConsts.START_DATE_ID()}" class="font-weight-bold">${addBookingConsts.START_DATE_LABEL()}</label>
            <input value="" type="date" class="form-control" id="${addBookingConsts.START_DATE_ID()}"
                   name="${addBookingConsts.START_DATE_ID()}">
        </div>
        <div class="form-group col">
            <label for="${addBookingConsts.END_DATE_ID()}" class="font-weight-bold">${addBookingConsts.END_DATE_LABEL()}</label>
            <input value="" type="date" class="form-control" id="${addBookingConsts.END_DATE_ID()}"
                   name="${addBookingConsts.END_DATE_ID()}">
        </div>
    </div>
    
</form>

<hr/>
<div id="bookingDetails">
    <h2 class="alert alert-info bg-info">${addBookingConsts.BOOKING_DETAILS()}</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Start date</th>
            <th scope="col">End date</th>
            <th scope="col">Client</th>
            <th scope="col">Book</th>
            <th scope="col">Cost per day</th>
            <th scope="col">Total cost</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
        </tr>
        </tbody>
        <tfooter>
            <tr class="table-info">
                <th colspan="6">Total booking cost</th>
                <th>5.5</th>
            </tr>
        </tfooter>
    </table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
