<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 21.01.2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi System - Details Page</title>
</head>
<body>
<h2>From address: ${order.fromAddress}</h2>
<h2>To address: ${order.toAddress}</h2>
<h2>Car type: ${order.carType}</h2>
<h2>Distance: ${order.distance}</h2>
<h2>Amount: ${order.amount}</h2>
<h2>Car: model ${order.car.model}, number ${order.car.number}</h2>
<h2>Time of car arrival: ${arrivalTime}</h2>

</body>
</html>
