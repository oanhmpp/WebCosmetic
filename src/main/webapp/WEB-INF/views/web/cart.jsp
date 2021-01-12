<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <%@include file="/common/web/head.jsp" %>
</head>

<body>
<!-- Top bar, Nav Bar, Bottom Bar -->
<%@include file="/common/web/header.jsp" %>

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Cart</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Cart Start -->
<div class="cart-page">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="cart-page-inner">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                            <tr>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:set var="priceTotal" value="${0}"/>
                            <c:forEach items="${cart}" var="cart">
                                <tr>
                                    <td>
                                        <div class="img">
                                            <a href="#"><img src="<c:url value="${cart.productEntity.image}" />"
                                                             alt="Image"></a>
                                            <p>${cart.productEntity.nameProduct}</p>
                                        </div>
                                    </td>
                                    <td>$${cart.productEntity.price}</td>
                                    <td>
                                        <div class="qty">
                                            <button class="btn-minus"><span hidden>${cart.id}</span><i
                                                    class="fa fa-minus"></i></button>
                                            <input type="number" value="${cart.number}">
                                            <button class="btn-plus"><span hidden>${cart.id}</span><i
                                                    class="fa fa-plus"></i></button>
                                        </div>
                                    </td>

                                    <c:set var="priceTotal" value="${priceTotal + cart.productEntity.price*cart.number}" />
                                    <td class="totalOneProduct">$${cart.productEntity.price*cart.number}</td>
                                    <td>
                                        <button id="btn_delter" class="btn_delete"><span hidden>${cart.id}</span><i class="fa fa-trash"></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart-page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="cart-summary">
                                <div class="cart-content">
                                    <h1>Cart Summary</h1>
                                    <%--                                            <p>Sub Total<span id="total">$0</span></p>--%>
                                    <%--                                            <p>Shipping Cost<span>$1</span></p>--%>
                                    <h2>Grand Total<span>$${priceTotal}</span></h2>
                                </div>
<%--                                <input hidden name="priceTotal" value="${priceTotal}">--%>
                                <div class="cart-btn d-flex justify-content-center">
                                    <button><a href="${pageContext.request.contextPath}/payment?priceTotal=${priceTotal}">Pay</a></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart End -->

<!-- Footer -->
<%@include file="/common/web/footer.jsp" %>
</body>
</html>
