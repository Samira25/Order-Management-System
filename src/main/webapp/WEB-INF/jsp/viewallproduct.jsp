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

        <h2>All Product</h2>

        <spring:url value="/addproduct" var="addproduct" />
        <c:if test="${!empty productlist}">
            <table class="table-bordered">

                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${productlist}" var="product">
                    <tr>
                        <td><c:out value="${product.id}" /></td>
                        <td><c:out value="${product.name}" /></td>
                        <td><c:out value="${product.price}" /></td>
                        <td><c:out value="${product.description}" /></td>
                        <td>
                            <a href="/editproduct/${product.id}">Edit</a>
                            <a href="/productdelete/${product.id}">Delete</a>
                            <a href="/detailproduct/${product.id}">Details</a>
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
