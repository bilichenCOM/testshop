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
                <td>Price: ${product.price}</td>
                <td>
                    <a href="<c:url value=""/>"
                    <button></button></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
