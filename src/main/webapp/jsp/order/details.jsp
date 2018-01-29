<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 21.01.2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="page" value="/jsp/order/details.jsp" scope="request"/>
<c:set var="title" value="details.title" scope="request"/>
<c:import url="/jsp/header.jsp"/>
<jsp:useBean id="leftTime" class="com.taxi_system.bean.TimeBean" scope="page"/>
<jsp:setProperty name="leftTime" property="leftTime" value="${savedOrder.expectedBoardingTime}"/>

<fmt:setLocale value="${sessionScope.locale}"/>

<fmt:bundle basename="pagecontent" prefix = "general." >
    <c:set var="multiplier"><fmt:message key="currencyCoefficient"/></c:set>
</fmt:bundle>

<fmt:bundle basename="pagecontent" prefix = "details." >

    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="from"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${savedOrder.fromAddress}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="to"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${savedOrder.toAddress}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="carType"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${savedOrder.carType}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="distance"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${savedOrder.distance}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="amount"/>:</P>
        </div>
        <div class="col-md-5">
            <p><fmt:formatNumber value="${savedOrder.amount * multiplier}" type="currency"/></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="car"/>:</P>
        </div>
        <div class="col-md-5">
            <p><fmt:message key="model"/> ${savedOrder.car.model}, <fmt:message key="number"/> ${savedOrder.car.number}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <P><fmt:message key="time"/>:</P>
        </div>
        <div class="col-md-5">
            <p>${leftTime.leftHours}<fmt:message key="hour"/> ${leftTime.leftMinutes}<fmt:message key="minute"/></p>
        </div>
    </div>

    <hr>

</fmt:bundle>

<c:import url="/jsp/footer.jsp" />