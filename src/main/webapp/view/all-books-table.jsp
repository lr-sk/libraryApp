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
<h2 class="bg-light p-3 rounded text-center">Books</h2>
<table class="table table-bordered table-hover mt-3">
    <thead class="table-info">
        <tr>
            <th scope="col" class="align-baseline">Name</th>
            <th scope="col" class="align-baseline">Original name</th>
            <th scope="col" class="align-baseline">Genres</th>
            <th scope="col" class="align-baseline">Authors</th>
            <th scope="col" class="align-baseline">Cost</th>
            <th scope="col" class="align-baseline">Per day</th>
            <th scope="col" class="align-baseline">Year</th>
            <th scope="col" class="align-baseline">Pages</th>
            <th scope="col" class="align-baseline">Copies</th>
<%--            <th scope="col">Available copies</th>--%>
            <th scope="col" class="align-baseline">Registration date</th>
            <th scope="col" class="align-baseline">Edit</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr id="${book.id}">
            <td scope="row">${book.name}</td>
            <td>${book.originalName}</td>
            <td>
                <c:forEach var="genre" items="${book.genres}">
                    <span id="${genre.id}" value="${genre.name}" class="badge badge-info mr-1">${genre.name}</span>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="author" items="${book.authors}">
                    <span id="${author.id}" value="${author.fullName}" class="badge badge-light mr-1">${author.fullName}</span>
                </c:forEach>
            </td>
            <td>${book.cost}</td>
            <td>${book.costPerDay}</td>
            <td>${book.yearOfPublishing}</td>
            <td>${book.numberOfPages}</td>
            <td><a href="book-copy" class="btn-link text-info text-decoration-none">${book.numberOfCopies}<i class="fas fa-chevron-right ml-2"></i></a></td>
<%--            <td>${book.availableCopies}</td>--%>
            <td>${book.registrationDate}</td>
            <td><a href="edit-book.jsp" class="btn btn-link btn-sm text-info">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
