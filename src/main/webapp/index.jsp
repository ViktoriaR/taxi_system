<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${empty sessionScope.locale}">
    <c:set var="locale" value="en_US" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "index." >
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>

    <h2>Hello World!</h2>
    <c:set var="page" value="/index.jsp" scope="request"/>
    <c:import url="jsp/header.jsp" />

    <c:if test="${!empty sessionScope.username}">
        <a href=?command=orderForm><fmt:message key="orderCar"/></a>
    </c:if><br>

    <c:if test="${!empty sessionScope.savedOrder}">
        <a href=${pageContext.request.contextPath}/jsp/details.jsp><fmt:message key="lastOrder"/></a>
    </c:if>

</body>
</html>
</fmt:bundle>