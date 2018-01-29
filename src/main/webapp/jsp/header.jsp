<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 24.01.2018
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "header." >
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.locale == 'en_US'}">
            <fmt:message key="english"/><br>
        </c:when>
        <c:otherwise>
            <a href=${pageContext.request.contextPath}/?command=changeLocale&locale=en_US&page=${requestScope.page}><fmt:message key="english"/></a><br>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${sessionScope.locale == 'ru_UA'}">
            <fmt:message key="russian"/><br>
        </c:when>
        <c:otherwise>
            <a href=${pageContext.request.contextPath}/?command=changeLocale&locale=ru_UA&page=${requestScope.page}><fmt:message key="russian"/></a><br>
        </c:otherwise>
    </c:choose>

    <a href=${pageContext.request.contextPath}><fmt:message key="main"/></a><br>

    <c:choose>
        <c:when test="${empty sessionScope.username}">
            <a href=${pageContext.request.contextPath}/?command=loginForm><fmt:message key="logIn"/></a><br>
            <a href=${pageContext.request.contextPath}/?command=registrationForm><fmt:message key="registration"/></a>
        </c:when>

        <c:otherwise>
            <a href=${pageContext.request.contextPath}/?command=logout><fmt:message key="logOut"/></a><br>
        </c:otherwise>
    </c:choose>
</body>
</html>
</fmt:bundle>