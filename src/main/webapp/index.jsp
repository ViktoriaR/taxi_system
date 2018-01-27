<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "index." >
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>

    <c:set var="page" value="/index.jsp" scope="request"/>
    <c:import url="jsp/header.jsp" />

    <c:if test="${!empty sessionScope.username}">
        <a href=?command=orderForm><fmt:message key="orderCar"/></a>
    </c:if><br>

    <c:if test="${!empty sessionScope.savedOrder}">
        <a href=${pageContext.request.contextPath}/jsp/order/details.jsp><fmt:message key="lastOrder"/></a>
    </c:if>

</body>
</html>
</fmt:bundle>