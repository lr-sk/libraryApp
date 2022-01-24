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
<h2 class="bg-light p-3 rounded text-center">Books gallery</h2>
<div class="card-deck mt-3">
    <c:forEach var="book" items="${books}">
        <div class="card bg-light">
            <div class="card-img-top">
                <img src="data:image/*;base64, ${book.images[0].imageString}" width="100%" height="350px">
            </div>

            <div class="card-body">
                <h5 class="card-title">${book.name}</h5>
                <p class="card-text">${book.originalName}</p>
                <div class="card-text py-3 border-top">
                    <c:forEach var="author" items="${book.authors}">
                        <span id="${author.id}" value="${author.fullName}" class="badge badge-dark">${author.fullName}</span>
                    </c:forEach>
                </div>
                <div class="card-text py-3 border-top">
                    <c:forEach var="genre" items="${book.genres}">
                        <span id="${genre.id}" value="${genre.name}" class="badge badge-info mr-1">${genre.name}</span>
                    </c:forEach>
                </div>
                <div class="card-text py-3 border-top">${book.yearOfPublishing}</div>
                <div class="card-text py-3 border-top">${book.costPerDay} per day</div>
            </div>


            <div class="card-footer d-flex justify-content-between">
                <div class="bookRating d-flex align-items-center"><i class="fas fa-star mr-1"></i>5.0</div>
                <div class="actionLinks d-flex justify-content-end">
                    <a href="book" class="btn btn-link text-info">View</a>
                    <a href="edit-book" class="btn btn-link text-info">Edit</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
