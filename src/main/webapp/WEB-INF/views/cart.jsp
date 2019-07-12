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

<%--user info area--%>
<div align="right">
    <security:authorize access="isAuthenticated()">
        <nav>
            logged as <security:authentication property="principal.username"/> |
            <a href="<c:url value="/cart"/>">CART<c:if test="${cart.size() gt 0}">(${cart.size()} items)</c:if></a> |
            <c:url value="/logout" var="logout_url"/>
            <spring:form action="${logout_url}" align="right" method="post">
                <button class="btn btn-danger" type="submit">Logout</button>
            </spring:form>
        </nav>
    </security:authorize>
</div>
<%----%>

<h2>Your cart ${cart.size()} items:</h2>
<div class="text-info">${cartMessage}</div>
<div class="text-success">${purchaseMessage}</div>
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

<c:if test="${cart.size() gt 0}">
    <span class="h2">Total price:</span><div class="text-success">${cart.totalPrice()}&dollar;</div>

    <a href="<c:url value="/purchase"/>">
        <button class="btn btn-primary">Purchase all!</button>
    </a>
</c:if>
<c:if test="${cart.size() eq 0}">
    <h6 align="center">no items yet... go to <a href="<c:url value="/categories"/>">categories&gt;</a></h6>
</c:if>

<%--date and time--%>
<div align="right">${dateTime}</div>
<%----%>
</body>
</html>
