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

<h2>Your cart items:</h2>
<div class="text-info">${cartMessage}</div>
<div class="text-info">${purchaseMessage}</div>
<table>
    <c:forEach var="product" items="${cart.products}">
        <tr>
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
                <a href="<c:url value="/cart/remove/product?product_id=${product.id}"/>">x</a>
            </td>
        </tr>
    </c:forEach>
</table>

<span class="h2">Total price:</span><div class="text-success">${cart.getTotalPrice()}&dollar;</div>

<a href="<c:url value="/purchase"/>">
    <button class="btn btn-primary">Purchase all!</button>
</a>

<%--date and time--%>
<div align="right">${dateTime}</div>
<%----%>
</body>
</html>
