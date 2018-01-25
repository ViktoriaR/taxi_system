<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 11.01.2018
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Taxi System - Order Page</title>
</head>
<body>
    <c:if test="${!empty failedMessage}">
        <h2>${failedMessage}</h2>
    </c:if>

    <c:set var="page" value="/jsp/orderForm.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp" />

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--From input field with value--%>
        <label for="fromAddress">From:</label>
        <input id="fromAddress" type="text" name="fromAddress" value="${order.fromAddress}"/><br>

        <%--To input field with value--%>
        <label for="toAddress">To:</label>
        <input id="toAddress" type="text" name="toAddress" value="${order.toAddress}"/><br>

        <%--To input field with value--%>
        <label for="carType">Choose car type:</label>
        <select id="carType" name="carType">
            <c:forEach var="carType" items="${carTypes}">
                <option value="${carType.type}">${carType.type}</option>
            </c:forEach>
        </select><br>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="getPrice"/>

        <input type="submit" value="Get price"/>
    </form>
</body>
</html>
