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
<fmt:bundle basename="pagecontent" prefix = "details." >
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <c:set var="page" value="/jsp/details.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp" />

    <fmt:message key="from"/>: ${savedOrder.fromAddress}<br>
    <fmt:message key="to"/>: ${savedOrder.toAddress}<br>
    <fmt:message key="carType"/>: ${savedOrder.carType}<br>
    <fmt:message key="distance"/>: <fmt:formatNumber value="${savedOrder.distance}"/><br>
    <fmt:message key="amount"/>: <fmt:formatNumber value="${savedOrder.amount}" type="currency"/><br>
    <fmt:message key="car"/>: <fmt:message key="model"/> ${savedOrder.car.model}, <fmt:message key="number"/> ${savedOrder.car.number}<br>
    <fmt:message key="time"/>:  <fmt:formatDate value="${savedOrder.expectedBoardingTime}" type="time" timeStyle="short"/><br>

    <a href="${pageContext.request.contextPath}"><fmt:message key="index"/></a><br>

</body>
</html>
</fmt:bundle>