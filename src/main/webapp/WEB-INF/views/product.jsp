<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Categories</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          crossorigin="anonymous">
</head>
<body>
<h1 class="">Good Company</h1>
<nav><a href="<c:url value="/welcome"/>">Welcome</a> | <a href="<c:url value="/categories"/>">Categories</a> |
    <a href="<c:url value="/signin"/>">Signin</a> | <a href="<c:url value="/signup"/>">Signup</a> </nav>

<%-- place for cart --%>
<div><a href="<c:url value="/cart"/>">Cart: ${cart.products.size()} items</a></div>
<%----%>

<h2>${category.name.toUpperCase()} &gt; ${product.name.toUpperCase()}</h2>
<div><img src="<c:url value="${product.imageUrl}"/>" weight="300" height="400"/>"></div>

<%-- here should be some status message to inform customer--%>
    <div>${message}</div>
<%----%>

    <div>Don't miss your chance to buy only for: ${product.price}&dollar;</div>
    <div>
        <a href="<c:url value="/cart/add/product?id=${product.id}" />">
            <button>Add to cart!</button>
        </a>
    </div>

    <div>Information about this product: ${product.description}</div>

    <h3>Other products in this category:</h3>
<table>
    <c:forEach var="product" items="${category.products}">
        <tr>
            <td>
                <img src="<c:url value="${product.imageUrl}"/>" alt="photo" width="200" height="150">
            </td>
            <td>
                <a href="<c:url value="/categories/category/product?id=${product.id}"/>">${product.name}</a>
            </td>
            <td>Price: ${product.price}</td>
            <td>
                <a href="<c:url value="/cart/add/product?id=${product.id}"/>">
                    <button>Add to cart!</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
