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
            <a href="<c:url value="/cart"/>">CART <c:if test="${cart.size() gt 0}">(${cart.size()} items)</c:if></a> |
            <c:url value="/logout" var="logout_url"/>
            <spring:form action="${logout_url}" align="right" method="post">
                <button class="btn btn-danger" type="submit">Logout</button>
            </spring:form>
        </nav>
    </security:authorize>
</div>
<%----%>


<h2><div class="text-uppercase">${category.name}</div></h2>
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
                    <a href="<c:url value="/cart/add/product?product_id=${product.id}"/>"><button>Add to cart!</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
<%--date and time--%>
<div align="right">${dateTime}</div>
<%----%>

</body>
</html>