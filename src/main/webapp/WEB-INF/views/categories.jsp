<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Categories</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
</head>
<body>
    <h1 class="">Good Company</h1>
    <nav><a href="/testshop/welcome">Welcome</a> | <a href="/testshop/categories">Categories</a> |
        <a href="/testshop/signin">Signin</a> | <a href="/testshop/signup">Signup</a></nav>

    <div align="right">
        <security:authorize access="isAuthenticated()">
            logged as <security:authentication property="principal.username"/>
        </security:authorize>
    </div>

    <h2>Categories</h2>
    <div>Here is our product categories</div>
    <div>${cartMessage}</div>
    <ul>
        <c:forEach var="category" items="${categories}">
            <li>
                <a href="/testshop/categories/category?id=${category.id}">${category.name}</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
