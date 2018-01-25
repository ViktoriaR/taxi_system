<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 21.01.2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Taxi System - Details Page</title>
</head>
<body>
<c:set var="page" value="/jsp/details.jsp" scope="request"/>
<c:import url="/jsp/header.jsp" />

<h2>From address: ${savedOrder.fromAddress}</h2>
<h2>To address: ${savedOrder.toAddress}</h2>
<h2>Car type: ${savedOrder.carType}</h2>
<h2>Distance: ${savedOrder.distance}</h2>
<h2>Amount: ${savedOrder.amount}</h2>
<h2>Car: model ${savedOrder.car.model}, number ${savedOrder.car.number}</h2>
<h2>Time of car arrival: ${savedOrder.expectedBoardingTime}</h2>

<a href="${pageContext.request.contextPath}">To main page</a><br>

</body>
</html>
