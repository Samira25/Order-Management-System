<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

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
            <a class="navbar-brand" href="#">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/welcome"/>">Home</a></li>
                <li><a href="<c:url value="/service"/>">Service</a></li>
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

        <h2>All Customer</h2>

        <spring:url value="/register" var="register" />
        <c:if test="${!empty userlist}">
            <table class="table-bordered">

                <tr>
                    <th>Id</th>
                    <th>Full Name</th>
                    <th>User Name</th>
                    <th>Phone</th>
                    <th>E-mail</th>
                    <th>Password</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${userlist}" var="user">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.name}" /></td>
                        <td><c:out value="${user.username}" /></td>
                        <td><c:out value="${user.phone}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><c:out value="${user.password}" /></td>
                        <td>
                            <a href="/edituser/${user.id}">Edit</a>
                            <a href="/userdelete/${user.id}">Delete</a>
                            <a href="/detailuser/${user.id}">Details</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </c:if>

    </div>

</div>
<!-- /.container -->

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
