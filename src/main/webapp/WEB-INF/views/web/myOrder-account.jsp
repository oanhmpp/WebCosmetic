<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <%@include file="/common/web/head.jsp" %>
</head>

<body>

<%@include file="/common/web/header.jsp" %>

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">My Account</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- My Account Start -->
<div class="my-account">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="nav flex-column nav-pills" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="dashboard-nav" data-toggle="pill" href="/myAccount" role="tab"><i
                            class="fa fa-tachometer-alt"></i>Profile detail</a>
                    <a class="nav-link" id="orders-nav" data-toggle="pill" href="myAccount/myAccountOrder" role="tab"><i
                            class="fa fa-shopping-bag"></i>Orders</a>
                    <a class="nav-link" href="/logout"><i class="fa fa-sign-out-alt"></i>Logout</a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="tab-content">
                    <table class="table table-striped" id="table-1">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name Customer</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Product</th>
                            <th>Price Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <p>
                            Total Product: <b id="total">${orderList.size()}</b>
                        </p>
                        <c:forEach var="order" items="${orderList}">
                            <tr>
                                <td>${order.idOrder}</td>
                                <td>
                                    <security:authentication property="principal.customer.nameCustomer"/>
                                </td>
                                <td>${order.address}</td>
                                <td>0${order.phone}</td>
                                <td>
                                    <c:forEach var="detailOrder" items="${detailOrderList}">
                                        <c:if test="${detailOrder.order.idOrder==order.idOrder}">
                                            <p>${detailOrder.nameProduct} <span>(${detailOrder.amount})</span></p>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>${order.totalPrice}</td>
                                    <%--                                                    <td><a href="/admin/">Show detail</a></td>--%>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</div>--%>
<!-- My Account End -->

<%--<%@include file="/common/web/footer.jsp" %>--%>

</body>
</html>
