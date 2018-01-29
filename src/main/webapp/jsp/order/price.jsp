<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 13.01.2018
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="multiplier"><fmt:message key="currencyCoefficient"/></c:set>
</fmt:bundle>
<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="exceptionMessage"><fmt:message key="${requestScope.exception}"/></c:set>
</fmt:bundle>
<fmt:bundle basename="pagecontent" prefix = "price.">
<html>
    <head>
    <title><fmt:message key="title"/></title>
    </head>
<body>
    <c:if test="${!empty requestScope.exception}">
        <h2>${exceptionMessage}</h2>
    </c:if>

    <c:set var="page" value="/jsp/order/price.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp"/>

    <fmt:message key="from"/>: ${order.fromAddress}<br>
    <fmt:message key="to"/>: ${order.toAddress}<br>
    <fmt:message key="carType"/>: ${order.carType}<br>
    <fmt:message key="distance"/>: <fmt:formatNumber value="${order.distance}"/><br>
    <fmt:message key="price"/>: <fmt:formatNumber value="${order.price * multiplier}" type="currency"/><br>
    <c:if test="${!empty order.discount}">
        <fmt:message key="discount"/>: <fmt:formatNumber value="${order.discount.percent}" type="percent"/><br>
    </c:if>
    <c:if test="${!empty order.stock}">
        <fmt:message key="stock"/>: <fmt:formatNumber value="${order.stock.percent}" type="percent"/><br>
    </c:if>
    <fmt:message key="amount"/>: <fmt:formatNumber value="${order.amount * multiplier}" type="currency"/><br>

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="processOrder"/>

        <input type="submit" value="<fmt:message key="submit"/>"/>
    </form>

</body>
</html>
</fmt:bundle>