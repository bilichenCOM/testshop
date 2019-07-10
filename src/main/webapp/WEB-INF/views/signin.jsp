<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="">Good Company</h1>
<nav><a href="<c:url value="/welcome"/>">Welcome</a> | <a href="<c:url value="/categories"/>">Categories</a> |
    <a href="<c:url value="/signin"/>">Signin</a> | <a href="<c:url value="/signup"/>">Signup</a> </nav>

<div>
    <spring:form modelAttribute="user" action="/testshop/signin" method="post" class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Please login</h1>
        <span>${message}</span>
        <label for="email" class="sr-only">Email</label>
        <spring:input path="email" id="email" name="email" class="form-control" placeholder="your email" required="true"/>
        <label for="password" class="sr-only">Password</label>
        <spring:input path="password" id="password" class="form-control" placeholder="your password" required="true"/>
        <button class="btn btn-lg btn-success" type="submit">Sign up</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
    </spring:form>
</div>
</body>
</html>