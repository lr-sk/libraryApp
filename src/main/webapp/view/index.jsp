<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mainConsts" class="com.ita.u1.skomorokhova.libraryApp.consts.jsp.MainConsts"/>
<!DOCTYPE html>
<html>
<head>
    <title>LibraryApp</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h1 class="bg-light p-3 rounded text-center">Library</h1>
</div>
<div class="container">
    <div class="list-group my-5">
        <h2 class="mb-3">${mainConsts.BOOKS_BLOCK_TITLE()}</h2>
        <a href="#" class="list-group-item list-group-item-action bg-light" data-toggle="collapse" data-target="#allBooksCollapseOptions" aria-expanded="false" aria-controls="allBooksCollapseOptions">
            ${mainConsts.ALL_BOOKS()} <i class="fas fa-caret-down"></i>
        </a>
        <div id="allBooksCollapseOptions" class="collapse show">
            <a href="all-books-table" class="list-group-item list-group-item-action"><i class="fas fa-circle mr-2"></i>${mainConsts.ALL_BOOKS_TABLE_VIEW()}</a>
            <a href="all-books-gallery" class="list-group-item list-group-item-action"><i class="fas fa-circle mr-2"></i>${mainConsts.ALL_BOOKS_GALLERY_VIEW()}</a>
        </div>
        <a href="add-book" class="list-group-item list-group-item-action bg-light">${mainConsts.ADD_BOOK()}</a>
    </div>
</div>
<div class="container">
    <div class="list-group my-5">
        <h2 class="mb-3">${mainConsts.BOOKINGS_BLOCK_TITLE()}</h2>
        <a href="all-booking" class="list-group-item list-group-item-action bg-light">${mainConsts.ALL_BOOKINGS()}</a>
        <a href="add-booking" class="list-group-item list-group-item-action bg-light">${mainConsts.ADD_BOOKING()}</a>
    </div>
</div>
<div class="container">
    <div class="list-group my-5">
        <h2 class="mb-3">${mainConsts.CLIENTS_BLOCK_TITLE()}</h2>
        <a href="all-clients" class="list-group-item list-group-item-action bg-light">${mainConsts.ALL_CLIENTS()}</a>
        <a href="add-client" class="list-group-item list-group-item-action bg-light">${mainConsts.ADD_CLIENT()}</a>
    </div>
</div>
<div class="container">
    <div class="list-group my-5">
        <h2 class="mb-3">${mainConsts.AUTHORS_BLOCK_TITLE()}</h2>
        <a href="all-authors" class="list-group-item list-group-item-action bg-light">${mainConsts.ALL_AUTHORS()}</a>
        <a href="add-author" class="list-group-item list-group-item-action bg-light">${mainConsts.ADD_AUTHOR()}</a>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>