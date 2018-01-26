<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 06.01.2018
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "loginForm." >
    <html>
    <head>
        <title><fmt:message key="title"/></title>
    </head>
<body>
    <%--Login failed message ONLY if login failed--%>
    <c:if test="${!empty requestScope.loginFailedMessage}">
        <h2>${requestScope.loginFailedMessage}</h2>
    </c:if>

    <c:set var="page" value="/jsp/loginForm.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp" />

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--Login input field with value and predifined attribute login from command--%>
        <label for="login"><fmt:message key="login"/>:</label>
        <input id="login" type="text" name="login" value="${requestScope.login}"/><br>

        <%--Password input field with label--%>
        <label for="password"><fmt:message key="password"/>:</label>
        <input id="password" type="password" name="password"/><br>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="login"/>

        <input type="submit" value="<fmt:message key="loginButton"/>"/>
    </form>
</body>
</html>
</fmt:bundle>