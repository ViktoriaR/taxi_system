<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<c:choose>
    <c:when test = "${empty sessionScope.username}">
        <a href=?command=loginForm>Log in</a><br>
        <a href=?command=registrationForm>Registration</a>
    </c:when>

    <c:otherwise>
        <a href=?command=logout>Log out</a><br>
        <a href=?command=orderForm>Order car</a><br>
    </c:otherwise>
</c:choose>

</body>
</html>
