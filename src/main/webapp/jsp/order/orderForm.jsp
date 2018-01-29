<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 11.01.2018
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="page" value="/jsp/order/orderForm.jsp" scope="request"/>
<c:set var="title" value="orderForm.title" scope="request"/>
<c:import url="/jsp/header.jsp" />

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:bundle basename="pagecontent" prefix = "orderForm." >

    <form action="${pageContext.request.contextPath}/" method="post">
        <%--From input field with value--%>
        <div class="form-group">
            <label for="fromAddress"><fmt:message key="from"/>:</label>
            <input class="form-control" id="fromAddress" type="text" name="fromAddress" value="${order.fromAddress}"/>
        </div>

        <%--To input field with value--%>
        <div class="form-group">
            <label for="toAddress"><fmt:message key="to"/>:</label>
            <input class="form-control" id="toAddress" type="text" name="toAddress" value="${order.toAddress}"/>
        </div>

        <%--To input field with value--%>
        <div class="form-group">
            <label for="carType"><fmt:message key="choose"/>:</label>
            <select class="form-control" id="carType" name="carType">
                <c:forEach var="carType" items="${carTypes}">
                    <option value="${carType.type}">${carType.type}</option>
                </c:forEach>
            </select>
        </div>

        <%--Command hidden attribute for resolving command which is invoked--%>
        <input class="form-control" type="hidden" name="command" value="getPrice"/>

        <button type="submit" class="btn btn-default"><fmt:message key="getPriceButton"/></button>
    </form>
</fmt:bundle>

<c:import url="/jsp/footer.jsp" />