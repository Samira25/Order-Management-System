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

        <h2>All Order</h2>

        <spring:url value="/addorder" var="addorder" />
        <c:if test="${!empty orderlist}">
            <table class="table-bordered">

                <tr>
                    <th>Id</th>
                    <th>Customer Id</th>
                    <th>Product Id</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th>Delivery Date</th>
                </tr>
                <c:forEach items="${orderlist}" var="order">
                    <tr>
                        <td><c:out value="${order.id}" /></td>
                        <td><c:out value="${order.customer_id}" /></td>
                        <td><c:out value="${order.product_id}" /></td>
                        <td><c:out value="${order.quantity}" /></td>
                        <td><c:out value="${order.total_price}" /></td>
                        <td><c:out value="${order.delivery_date}" /></td>
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
