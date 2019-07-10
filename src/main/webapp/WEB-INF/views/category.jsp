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
<nav><a href="<c:url value="/welcome"/>">Welcome</a> | <a href="<c:url value="/categories"/>">Categories</a> |
    <a href="<c:url value="/signin"/>">Signin</a> | <a href="<c:url value="/signup"/>">Signup</a></nav>

<div align="right">
    <security:authorize access="isAuthenticated()">
        logged as <security:authentication property="principal.username"/>
    </security:authorize>
</div>

<h2>${category.name.toUpperCase()}</h2>
    <div>${category.description}</div>
    <table>
        <c:forEach var="product" items="${category.products}">
            <tr>
                <td>
                    <img src="<c:url value="${product.imageUrl}"/>" alt="photo" width="200" height="150">
                </td>
                <td>
                    <a href="<c:url value="/categories/category/product?id=${product.id}"/>">${product.name}</a>
                </td>
                <td>
                    <div>Price: ${product.price}</div>
                </td>
                <td>
                    <a href="<c:url value="/cart/add/product?id=${product.id}"/>"><button>Add to cart!</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
