<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 13.01.2018
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Taxi System - Price page</title>
</head>
<body>
    <c:if test="${!empty exception}">
        <h2>${exception}</h2>
    </c:if>

    <c:set var="page" value="/jsp/price.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp"/>

    <h2>From address: ${order.fromAddress}</h2>
    <h2>To address: ${order.toAddress}</h2>
    <h2>Car type: ${order.carType}</h2>
    <h2>Distance: ${order.distance}</h2>
    <h2>Price: ${order.price}</h2>
    <h2>Discount: ${order.discount.percent}</h2>
    <h2>Stock: ${order.stock.percent}</h2>
    <h2>Amount: ${order.amount}</h2>

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="processOrder"/>

        <input type="submit" value="Find car"/>
    </form>

</body>
</html>
