<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

<div align="right">
    <security:authorize access="isAuthenticated()">
        logged as <security:authentication property="principal.username"/> |
        <a href="<c:url value="/cart"/>">CART</a> |
        <a href="<c:url value="/logout"/>">Log out</a>
    </security:authorize>
</div>


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
