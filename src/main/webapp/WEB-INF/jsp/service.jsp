<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: samira
  Date: 2/27/2018
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service</title>
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
                <li class="active"><a href="<c:url value="/service"/>">Service</a></li>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/login"/>">Login</a></li>
                    <li><a href="<c:url value="/register"/>">Register</a></li>
                </ul>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <a href="<c:url value="/viewalluser"/>">View all Customer</a><br><br><br>
        <a href="<c:url value="/addproduct"/>">Add new Product</a><br><br>
        <a href="<c:url value="/viewallproduct"/>">View all Product</a><br><br><br>
        <a href="<c:url value="/viewallorder"/>">View all Order</a><br><br><br>
        <a href="<c:url value="/viewallrole"/>">View all Role</a><br><br><br>
        <a href="<c:url value="/viewalluser_role"/>">View all User Role</a><br><br><br>
    </div>

</div>
<!-- /.container -->

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
