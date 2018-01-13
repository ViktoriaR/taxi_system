<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 13.01.2018
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi System - Price page</title>
</head>
<body>

<h2>From address: ${order.fromAddress}</h2>
<h2>To address: ${order.toAddress}</h2>
<h2>Car type: ${carType}</h2>
<h2>Distance: ${order.distance}</h2>
<h2>Price: ${order.price}</h2>
<h2>Discount: ${order.discount.percent}</h2>
<h2>Stock: ${order.stock.percent}</h2>
<h2>Amount: ${order.amount}</h2>

<form action="/" method="post">
    <%--From input field with value--%>
</form>

</body>
</html>
