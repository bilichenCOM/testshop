<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Delivery Info</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/checkout/">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

<div class="container">
    <table >
        <tr>
            <td>
                <c:url value="/purchase" var="post_url"/>
                <spring:form modelAttribute="dip" action="${post_url}" method="post" class="form-checkout">
                    <h1 class="h3 mb-3 font-weight-normal">Delivery info</h1>
                    <span>${message}</span>
                    <label for="firstName">First name:</label>
                    <spring:input path="firstName" id="firstName" class="form-control"/>
                    <spring:errors path="firstName" cssClass="alert alert-danger"/>
                    <label for="lastName">Last name:</label>
                    <spring:input path="lastName" id="lastName" class="form-control" />
                    <spring:errors path="lastName" cssClass="alert alert-danger"/>
                    <label>Username: ${user.name}</label><br />
                    Email <div class="text-muted">${user.email}</div><br />
                    <label for="street">Street:</label>
                    <spring:input path="street" id="street" class="form-control" />
                    <spring:errors path="street" cssClass="alert alert-danger"/>
                    <label for="city">City:</label>
                    <spring:input path="city" id="city" class="form-control" />
                    <spring:errors path="city" cssClass="alert alert-danger"/>
                    <label for="country">Country:</label>
                    <spring:select path="country" id="country">
                        <spring:option value="none" label="Choose..."/>
                        <spring:option value="UA" label="Ukraine"/>
                        <spring:option value="EU" label="Other Europe"/>
                    </spring:select>
                    <spring:errors path="country" cssClass="alert alert-danger"/>
                    <label for="zip">Zip:</label>
                    <spring:input path="zip" id="zip" class="form-control" />
                    <spring:errors path="zip" cssClass="alert alert-danger"/>
                    <button class="btn btn-lg btn-success" type="submit">Confirm your order!</button>
                    <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
                </spring:form>
            </td>
            <td valign="top">
                Your cart:
                <ul>
                    <c:forEach var="product" items="${cart.products}">
                        <li>
                            ${product.name}: ${product.price}
                        </li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </table>
</div>
</div>
</body>
</html>
