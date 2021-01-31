<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 31.01.2021
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add book</title>
</head>
<body>
<h2>Add book form:</h2>
    <form:form method="post" modelAttribute="book">


<%--@ManyToMany--%>
<%--private List<Author> authors = new ArrayList<>();--%>

        <div>
            <label for="title">title</label>
            <form:input type="text" id="title" path="title" />
        </div>
        <div>
            <label for="rating">rating</label>
            <form:input type="number" min="1" max="10" id="rating" path="rating" />
        </div>
        <div>
            <label for="description">description</label>
            <form:textarea id="description" path="description" />
        </div>
        <div>
            <label for="publisher">publisher</label>
            <form:select path="publisher.id" id="publisher" items="${publishers}" itemValue="id" itemLabel="name" />
        </div>

        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>
