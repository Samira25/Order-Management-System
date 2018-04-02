<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

    <style>
        table, th, td {
            padding: 5px;
            text-align: center;
        }
        a {
            cursor: pointer;
        }
    </style>

    <script>
        var items=[];
        var price=[];
        function addItemPrice(v,p) {
            items.push(v);
            $('.items').html(items.length);

            price.push(p);
            var total = 0 ;
            for (var i = 0 ; i < price.length ; i++) {
                total+=price[i];
            }
            $('.price').html(total);
        }

        function saveOrders() {
            console.log(items, price);
            var URL='<%=request.getContextPath()%>/saveOrders?items='+items+'&&price='+price;
            $.ajax({
                type: "get",
                url: URL,
                cache: false,
                data: JSON.stringify(items, price),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    console.log("Success", data);
                },
                error: function (e) {
                    console.log("Error", e);
                }
            });
        }

        function minusItemPrice(x,y) {
            var i = items.indexOf(x);
            if (i != -1) {
                items.splice(i, 1);
            }
            $('.items').html(items.length);

            var j = price.indexOf(y);
            if (j != -1) {
                price.splice(j, 1);
            }
            var total = 0 ;
            for (var k = 0 ; k < price.length ; k++) {
                total+=price[k];
            }
            $('.price').html(total);
        }

        $(function () {
            $('.value').click(function () {
                $(this).prop("disabled", true);
                $(this).val("Added");
            });
            $('.minus').click(function () {
                $('.value').each(function () {
                    $(this).prop("disabled", false);
                    $('.value').val("Item");
                });
                $(this).prop("disabled", true);
                $(this).val("Removed");
            });
        });
    </script>


</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/welcome"/>">Spring Boot</a>
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
        <div style="text-align: center">
            <h3>Total Item: <span class="items"></span></h3>
            <h3>Total Price: <span class="price"></span></h3>
            <a id="submitorder" onclick="saveOrders()" class="btn btn-primary btn-lg">Place Order</a>
        </div>

        <spring:url value="/addproduct" var="addproduct" />
        <c:if test="${!empty productlist}">
            <div class="well"><table class="table-bordered" width="100%">

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
                        <td><c:out value="${product.name}" />

                        </td>
                        <td><c:out value="${product.price}" /></td>
                        <td><c:out value="${product.description}" /></td>
                        <td>
                            <a href="/editproduct/${product.id}">Edit</a>
                            <a href="/productdelete/${product.id}">Delete</a>
                            <a href="/detailproduct/${product.id}">Details</a>
                            <button type="button" id="value" class="btn btn-info btn-sm value"
                                    onclick="addItemPrice(${product.id},${product.price})">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                            <button type="button" id="minus" class="btn btn-info btn-sm minus"
                                    onclick="minusItemPrice(${product.id},${product.price})">
                                <span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
                        </td>
                    </tr>
                </c:forEach>

            </table></div>
        </c:if>

    </div>

</div>
<!-- /.container -->

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
