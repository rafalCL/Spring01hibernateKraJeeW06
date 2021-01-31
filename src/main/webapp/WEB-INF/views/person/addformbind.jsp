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
    <title>Add person</title>
</head>
<body>
<h2>Add person form:</h2>
    <form:form method="post" modelAttribute="person">
        <div>
            <label for="login">Login</label>
            <form:input type="text" id="login" path="login" />
        </div>
        <div>
            <label for="password">Password</label>
            <form:password id="password" path="password" />
        </div>
        <div>
            <label for="email">Email</label>
            <form:input type="email" id="email" path="email" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>
