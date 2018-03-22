<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: samira
  Date: 2/28/2018
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/welcome"/>">Home</a></li>
                <li><a href="<c:url value="/service"/>">Service</a></li>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="<c:url value="/login"/>">Login</a></li>
                    <li><a href="<c:url value="/register"/>">Register</a></li>
                </ul>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <form:form action="/login" modelAttribute="login" method="post">
        User Name: <form:input path="username" /><br><br>
        Password: <form:password path="password" /><br><br>
        <input type="submit" value="Login"><br><br>
        <p>Not a member? <a href="<c:url value="/register"/>">Register</a></p>
    </form:form>

</div>
<!-- /.container -->

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
