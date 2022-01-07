<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New book</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Add new book</h1>
<form method="post">
    <div class="form-group">
        <label for="bookName">Book name</label>
        <input type="text" class="form-control" id="bookName" placeholder="Enter book name">
    </div>
    <div class="form-group">
        <label for="bookName">Original book name</label>
        <input type="text" class="form-control" id="originalBookName" placeholder="Enter original book name">
    </div>
    <div class="form-group">
        <label for="bookGenres">Select book genres</label>
        <select multiple class="form-control" id="bookGenres">
            <c:forEach var="genre" items="${genres}">
                <option>${genre}</option>
            </c:forEach>
            <option><a href="add-genre">Add new</a></option>
        </select>
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
