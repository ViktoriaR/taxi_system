
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="page" value="/index.jsp" scope="request"/>
<c:set var="title" value="index.title" scope="request"/>
<c:import url="/jsp/header.jsp"/>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "index." >

    <c:choose>
        <c:when test="${!empty sessionScope.username}">
            <a class="btn btn-primary" href=${pageContext.request.contextPath}?command=orderForm><fmt:message key="orderCar"/></a>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info">
                <p><fmt:message key="pleaseLogin"/></p>
            </div>
        </c:otherwise>
    </c:choose>

    <c:if test="${!empty sessionScope.savedOrder}">
        <div class="clearfix"></div>
        <a class="btn btn-primary" href=${pageContext.request.contextPath}?command=orderDetails><fmt:message key="lastOrder"/></a>
    </c:if>

</fmt:bundle>

<c:import url="/jsp/footer.jsp" />