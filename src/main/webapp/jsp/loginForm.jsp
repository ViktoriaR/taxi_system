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

<c:set var="page" value="/jsp/loginForm.jsp" scope="request"/>
<c:set var="title" value="loginForm.title" scope="request"/>
<c:import url="/jsp/header.jsp" />

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "loginForm." >

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--Login input field with value and predifined attribute login from command--%>
        <div class="form-group">
            <label for="login"><fmt:message key="login"/>:</label>
            <input class="form-control" id="login" type="text" name="login" value="${requestScope.login}"/>
        </div>

        <%--Password input field with label--%>
        <div class="form-group">
            <label for="password"><fmt:message key="password"/>:</label>
            <input class="form-control" id="password" type="password" name="password"/>
        </div>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input class="form-control" type="hidden" name="command" value="login"/>

        <button type="submit" class="btn btn-default"><fmt:message key="loginButton"/></button>
    </form>
</fmt:bundle>

<c:import url="/jsp/footer.jsp" />