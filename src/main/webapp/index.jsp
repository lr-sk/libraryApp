<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>LibraryApp</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h1 class="text-center">Library</h1>
</div>
<div class="container">
    <div class="list-group">
        <h2>Books</h2>
        <a href="all-books" class="list-group-item list-group-item-action">All books</a>
        <a href="add-book" class="list-group-item list-group-item-action">Add book</a>
    </div>
</div>
<div class="container">
    <div class="list-group">
        <h2>Bookings</h2>
        <a href="all-books" class="list-group-item list-group-item-action">All bookings</a>
        <a href="add-book" class="list-group-item list-group-item-action">Add booking</a>
    </div>
</div>
<div class="container">
    <div class="list-group">
        <h2>Clients</h2>
        <a href="all-clients" class="list-group-item list-group-item-action">All clients</a>
        <a href="add-client" class="list-group-item list-group-item-action">Add client</a>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>