<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 09.01.2018
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi System - Registration Page</title>
</head>
<body>
    <%--Registrarion failed message ONLY if registration failed--%>
    <c:if test="${!empty registrationFailedMessage}">
        <h2>${registrationFailedMessage}</h2>
    </c:if>

    <form action="/" method="post">
        <%--Login input field with value and predifined attribute username from command--%>
        <label for="login">Login:</label>
        <input id="login" type="text" name="login" value="${login}"/><br>

        <%--Password input field with label--%>
        <label for="password">Password:</label>
        <input id="password" type="password" name="password"/><br>

        <%--Name input field with label--%>
        <label for="name">Name:</label>
        <input id="name" type="text" name="name" value="${name}"/><br>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="registration"/>

        <input type="submit" value="Registration"/>
    </form>
</body>
</html>
