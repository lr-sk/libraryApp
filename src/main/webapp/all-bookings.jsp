<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All books</title>
</head>
<body>
<h1>Books</h1>
<table>
    <thead class="table-head">
    <tr>
        <td>Image</td>
        <td>Id</td>
        <td>Name</td>
        <td>Original name</td>
        <td>Genres</td>
        <td>Authors</td>
        <td>Authors</td>
        <td>Cost</td>
        <td>Cost per day</td>
        <td>Year of publishing</td>
        <td>Number of pages</td>
        <td>Number of copies</td>
        <td>Available copies</td>
        <td>Date of registration</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.image}</td>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.originalName}</td>
            <td>${book.genres}</td>
            <td>${book.authors}</td>
            <td>${book.cost}</td>
            <td>${book.costPerDay}</td>
            <td>${book.yearOfPublishing}</td>
            <td>${book.numberOfPagies}</td>
            <td>${book.numberOfCopies}</td>
            <td>${book.dateOfRegistration}</td>
            <td>${book.numberOfCopies}</td>
            <td>${book.availableCopies}</td>
            <td>${book.dateOfRegistration}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
