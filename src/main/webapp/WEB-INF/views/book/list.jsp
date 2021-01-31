<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 31.01.2021
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All books</title>
</head>
<body>
<h2>Book list:</h2>
<table border="1">
    <tr><th>id</th><th>title</th><th>rating</th><th>Publisher</th><th>description</th></tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher}</td>
            <td>${book.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
