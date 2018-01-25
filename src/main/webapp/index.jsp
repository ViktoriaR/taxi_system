<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="en_en"/>
<fmt:bundle basename="pagecontent" prefix = "index." >
<html>
<body>

    <fmt:message key="orderCar"/>

    <h2>Hello World!</h2>
    <c:set var="page" value="/index.jsp" scope="request"/>
    <%--<c:import url="jsp/header.jsp" />--%>

    <c:if test="${!empty sessionScope.username}">
        <a href=?command=orderForm><fmt:message key="orderCar"/></a>
    </c:if><br>

    <c:if test="${!empty sessionScope.savedOrder}">
        <a href=${pageContext.request.contextPath}/jsp/details.jsp><fmt:message key="lastOrder"/></a>
    </c:if>


</body>
</html>
</fmt:bundle>