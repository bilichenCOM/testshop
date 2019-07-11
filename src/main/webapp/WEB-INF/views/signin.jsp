<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head class="bg-light">
    <title>Signin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
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
<div>
    <c:url value="/purchase" var="post_url"/>
    <spring:form modelAttribute="user" action="${post_url}" method="post" class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Please login</h1>
        <span>${message}</span>
        <label for="email" class="sr-only">Email</label>
        <spring:input path="email" id="email" name="email" class="form-control" placeholder="your email"
                      required="true"/>
        <label for="password" class="sr-only">Password</label>
        <spring:input path="password" id="password" class="form-control" placeholder="your password"
                      required="true"/>
        <button class="btn btn-lg btn-success" type="submit">Sign up</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
    </spring:form>
</div>

<%--date and time--%>
<div align="right">${dateTime}</div>
<%----%>

</body>
</html>