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
    <title>Person details</title>
</head>
<body>
    <h2>Person details:</h2>
    <p><c:out value="${person}" default="not provided" /></p>
</body>
</html>
