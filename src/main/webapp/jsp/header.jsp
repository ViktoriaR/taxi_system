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

<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="exceptionMessage"><fmt:message key="${requestScope.exception}"/></c:set>
</fmt:bundle>

<fmt:bundle basename="pagecontent">
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap.css" >
    <title><fmt:message key="${requestScope.title}"/></title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><fmt:message key="header.main"/></a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <c:choose>
                        <c:when test="${empty sessionScope.username}">
                            <li class="nav-item">
                                <a class="nav-link" href=${pageContext.request.contextPath}/?command=loginForm><fmt:message key="header.logIn"/></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href=${pageContext.request.contextPath}/?command=registrationForm><fmt:message key="header.registration"/></a>
                            </li>
                        </c:when><c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href=${pageContext.request.contextPath}/?command=logout><fmt:message key="header.logOut"/></a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="btn-group col-md-7" style="margin:5px 0 10px 0;">
                <c:choose>
                    <c:when test="${sessionScope.locale == 'en_US'}">
                        <div class="btn btn-info active"><fmt:message key="header.english"/></div>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-info" href=${pageContext.request.contextPath}/?command=changeLocale&locale=en_US&page=${requestScope.page}><fmt:message key="header.english"/></a>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${sessionScope.locale == 'ru_UA'}">
                        <div class="btn btn-info active"><fmt:message key="header.russian"/></div>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-info" href=${pageContext.request.contextPath}/?command=changeLocale&locale=ru_UA&page=${requestScope.page}><fmt:message key="header.russian"/></a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
		
		<c:if test="${!empty requestScope.exception}">
			<div class="alert alert-warning">
				<h2>${exceptionMessage}</h2>
			</div>
		</c:if>
		
</fmt:bundle>