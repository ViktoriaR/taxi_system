<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 11.01.2018
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="exceptionMessage"><fmt:message key="${requestScope.exception}"/></c:set>
</fmt:bundle>
<fmt:bundle basename="pagecontent" prefix = "orderForm." >
<html>
    <head>
    <title><fmt:message key="title"/></title>
    </head>
<body>
    <c:if test="${!empty requestScope.exception}">
        <h2>${exceptionMessage}</h2>
    </c:if>

    <c:set var="page" value="/jsp/order/orderForm.jsp" scope="request"/>
    <c:import url="/jsp/header.jsp" />

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--From input field with value--%>
        <label for="fromAddress"><fmt:message key="from"/>:</label>
        <input id="fromAddress" type="text" name="fromAddress" value="${order.fromAddress}"/><br>

        <%--To input field with value--%>
        <label for="toAddress"><fmt:message key="to"/>:</label>
        <input id="toAddress" type="text" name="toAddress" value="${order.toAddress}"/><br>

        <%--To input field with value--%>
        <label for="carType"><fmt:message key="choose"/>:</label>
        <select id="carType" name="carType">
            <c:forEach var="carType" items="${carTypes}">
                <option value="${carType.type}">${carType.type}</option>
            </c:forEach>
        </select><br>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input type="hidden" name="command" value="getPrice"/>

        <input type="submit" value="<fmt:message key="getPriceButton"/>"/>
    </form>
</body>
</html>
</fmt:bundle>