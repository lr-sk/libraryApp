<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All books</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Books</h1>
<table>
    <tr>
        <th>Image</th>
        <th>Id</th>
        <th>Name</th>
        <th>Original name</th>
<%--        <th>Genres</th>--%>
<%--        <th>Authors</th>--%>
        <th>Cost</th>
        <th>Cost per day</th>
        <th>Year of publishing</th>
        <th>Number of pages</th>
        <th>Number of copies</th>
<%--        <th>Available copies</th>--%>
        <th>Registration date</th>
        <th>Edit</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.image}</td>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.originalName}</td>
<%--            <td>${book.genres}</td>--%>
<%--            <td>${book.authors}</td>--%>
            <td>${book.cost}</td>
            <td>${book.costPerDay}</td>
            <td>${book.yearOfPublishing}</td>
            <td>${book.numberOfPages}</td>
            <td>${book.numberOfCopies}</td>
<%--            <td>${book.availableCopies}</td>--%>
            <td>${book.registrationDate}</td>
            <td><a href="edit-book.jsp">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
