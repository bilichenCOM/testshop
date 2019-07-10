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

<h2>Your cart items:</h2>
<div>${cartMessage}</div>
<table>
    <c:forEach var="product" items="${cart.products}">
        <td>
            <img src="<c:url value="${product.imageUrl}"/>" height="200" width="150" alt="${product.name} photo">
        </td>
        <td>
            <div>${product.name} from: ${product.category.name}</div>
        </td>
        <td>
            <div>Price: ${product.price}&dollar;</div>
        </td>
        <td>
            <a href="<c:url value="/cart/remove/product?id=${product.id}"/>">x</a>
        </td>
    </c:forEach>
</table>

<h2>Total price:</h2><div>${cart.getTotalPrice()}</div>

<a href="<c:url value="/purchase/cart?id=${cart.id}"/>">
    <button>Purchase all!</button>
</a>

</body>
</html>
