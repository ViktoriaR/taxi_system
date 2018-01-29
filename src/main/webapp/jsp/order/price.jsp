<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 13.01.2018
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="page" value="/jsp/order/price.jsp" scope="request"/>
<c:set var="title" value="price.title" scope="request"/>
<c:import url="/jsp/header.jsp"/>

<fmt:setLocale value="${sessionScope.locale}"/>

<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="multiplier"><fmt:message key="currencyCoefficient"/></c:set>
</fmt:bundle>

<fmt:bundle basename="pagecontent" prefix = "price." >

    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="from"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${order.fromAddress}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="to"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${order.toAddress}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="carType"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${order.carType}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="distance"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${order.distance}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="price"/>:</P>
        </div>
        <div class="col-md-5">
            <p><fmt:formatNumber value="${order.price * multiplier}" type="currency"/></p>
        </div>
    </div>

    <c:if test="${!empty order.discount}">
        <div class="row">
            <div class="col-md-3">
                <P><fmt:message key="discount"/>:</P>
            </div>
            <div class="col-md-5">
                <p><fmt:formatNumber value="${order.discount.percent}" type="percent"/></p>
            </div>
        </div>
    </c:if>
    <c:if test="${!empty order.stock}">
        <div class="row">
            <div class="col-md-3">
                <P><fmt:message key="stock"/>:</P>
            </div>
            <div class="col-md-5">
                <p><fmt:formatNumber value="${order.stock.percent}" type="percent"/></p>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="amount"/>:</P>
        </div>
        <div class="col-md-5">
            <p><fmt:formatNumber value="${order.amount * multiplier}" type="currency"/></p>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--Command hidden attribute for resolving command which is invoked--%>
        <input class="form-control" type="hidden" name="command" value="processOrder"/>

        <button type="submit" class="btn btn-default"><fmt:message key="submit"/></button>
    </form>
</fmt:bundle>

<c:import url="/jsp/footer.jsp" />