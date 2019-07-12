<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Categories</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
</head>
<body class="bg-light">
<h1 class="">Good Company</h1>
<nav><a href="<c:url value="/welcome"/>">Welcome</a> | <a href="<c:url value="/categories"/>">Categories</a> |
    <security:authorize access="isAuthenticated() == false">
        <a href="<c:url value="/signin"/>">Signin</a> | <a href="<c:url value="/signup"/>">Signup</a>
    </security:authorize>
</nav>

<%--user info area--%>
<div align="right">
    <security:authorize access="isAuthenticated()">
        <nav>
            logged as <security:authentication property="principal.username"/> |
            <a href="<c:url value="/cart"/>">CART <c:if test="${cart.size() gt 0}">(${cart.size()} items)</c:if></a> |
            <c:url value="/logout" var="logout_url"/>
            <spring:form action="${logout_url}" align="right" method="post">
                <button class="btn btn-danger" type="submit">Logout</button>
            </spring:form>
        </nav>
    </security:authorize>
</div>
<%----%>


<h2>Categories</h2>
    <div>Here is our product categories</div>
    <div class="text-info">${cartMessage}</div>
    <ul>
        <c:forEach var="category" items="${categories}">
            <li>
                <a href="/testshop/categories/category?id=${category.id}">${category.name}</a>
            </li>
        </c:forEach>
    </ul>

    <%--date and time--%>
    <div align="right">${dateTime}</div>
    <%----%>

</body>
</html>
