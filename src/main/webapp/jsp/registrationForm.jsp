<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 09.01.2018
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="exceptionMessage"><fmt:message key="${requestScope.exception}"/></c:set>
</fmt:bundle>
<fmt:bundle basename="pagecontent" prefix = "registrationForm." >
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <%--Registrarion failed message ONLY if registration failed--%>
    <c:if test="${!empty requestScope.exception}">
        <h2>${exceptionMessage}</h2>
    </c:if>

    <c:set var="page" value="/jsp/registrationForm.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp" />

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--Login input field with value and predifined attribute login from command--%>
        <label for="login"><fmt:message key="login"/>:</label>
        <input id="login" type="text" name="login" value="${requestScope.login}"/><br>

        <%--Password input field with label--%>
        <label for="password"><fmt:message key="password"/>:</label>
        <input id="password" type="password" name="password"/><br>

        <%--Name input field with value and predifined attribute name from command--%>
        <label for="name"><fmt:message key="name"/>:</label>
        <input id="name" type="text" name="name" value="${requestScope.name}"/><br>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="registration"/>

        <input type="submit" value="<fmt:message key="registrationButton"/>"/>
    </form>
</body>
</html>
</fmt:bundle>