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
    <title>Add person</title>
</head>
<body>
<h2>Add person form:</h2>
    <form method="post">
        <div>
            <label for="login">Login</label>
            <input type="text" id="login" name="login" />
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" />
        </div>
        <div>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form>
</body>
</html>
