<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 21.01.2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="multiplier"><fmt:message key="currencyCoefficient"/></c:set>
</fmt:bundle>
<fmt:bundle basename="pagecontent" prefix = "details." >
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <c:set var="page" value="/jsp/order/details.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp" />
    <jsp:useBean id="leftTime" class="com.taxi_system.bean.TimeBean" scope="page"/>
    <jsp:setProperty name="leftTime" property="leftTime" value="${savedOrder.expectedBoardingTime}"/>

    <fmt:message key="from"/>: ${savedOrder.fromAddress}<br>
    <fmt:message key="to"/>: ${savedOrder.toAddress}<br>
    <fmt:message key="carType"/>: ${savedOrder.carType}<br>
    <fmt:message key="distance"/>: <fmt:formatNumber value="${savedOrder.distance}"/><br>
    <fmt:message key="amount"/>: <fmt:formatNumber value="${savedOrder.amount * multiplier}" type="currency"/><br>
    <fmt:message key="car"/>: <fmt:message key="model"/> ${savedOrder.car.model}, <fmt:message key="number"/> ${savedOrder.car.number}<br>
    <fmt:message key="time"/>: ${leftTime.leftHours}<fmt:message key="hour"/> ${leftTime.leftMinutes}<fmt:message key="minute"/><br>

</body>
</html>
</fmt:bundle>