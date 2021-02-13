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
    <style>
        .cssErrors {
            color: orangered;
        }
    </style>
</head>
<body>
<h2>Add book form:</h2>
    <form:form method="post" modelAttribute="book">
        <div>
            <label for="title">title</label>
            <form:input type="text" id="title" path="title" />
            <form:errors path="title" />
        </div>
        <div>
            <label for="rating">rating</label>
            <form:input type="number" min="1" max="10" id="rating" path="rating" />
            <form:errors path="rating" />
        </div>
        <div>
            <label for="description">description</label>
            <form:textarea id="description" path="description" />
            <form:errors path="description" />
        </div>
        <div>
            <label for="publisher">publisher</label>
            <form:select path="publisher.id" id="publisher" items="${publishers}" itemValue="id" itemLabel="name" />
            <form:errors path="publisher" />
        </div>
        <div>
            <label for="authors">authors</label>
            <form:select path="authors" id="authors" items="${authors}" itemValue="id" itemLabel="fullName" multiple="true"/>
            <form:errors path="authors" />
        </div>
        <div>
            <label for="pages">pages</label>
            <form:input type="number" id="pages" path="pages" />
            <form:errors path="pages" />
        </div>

        <div>
            <input type="submit" />
        </div>
        <div>
            <form:errors path="*" element="p" cssClass="cssErrors" />
        </div>
    </form:form>
</body>
</html>
