<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <%@include file="/common/web/head.jsp" %>
</head>

<body>
<!-- Top bar, Nav Bar, Bottom Bar -->
<%@include file="/common/web/header.jsp" %>

<div class="col-sm-12 d-flex justify-content-center">
    <div class="">
        <h5 class="text-uppercase" style="color: #ff6f61">E Store</h5>
        <h4 class="mt-5 theme-color mb-5">Thanks for your order</h4>
        <div class="mb-3">
            <hr class="new1">
        </div>
        <div class="d-flex justify-content-between">
            <div class="cart-page-inner col-sm-12">
                <div class="table-responsive col-sm-12">
                    <div class="infor_customer">
                                <div class="col-md-6">
                                    <label>Name: </label>
                                    <span><security:authentication property="principal.customer.nameCustomer"/></span>
                                </div>
                                <div class="col-md-6">
                                    <label>Phone: </label>
                                    <span><security:authentication property="principal.customer.phone"/></span>
                        </div>
                    </div>
                    <p>------------------------------ </p>
                    <table class="table table-bordered ">
                        <thead class="thead-dark">
                        <tr>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody class="align-middle">
                        <c:set var="priceTotal" value="${0}"/>
                        <c:forEach items="${detailOrderList}" var="detailOrder">
                            <tr>
                                <td>
                                        ${detailOrder.nameProduct}
                                </td>
                                <td>$${detailOrder.price}</td>
                                <td>
                                    <div class="qty">
                                            ${detailOrder.amount}
                                    </div>
                                </td>

                                <c:set var="priceTotal" value="${priceTotal + detailOrder.price}"/>
                                <td class="totalOneProduct">$${detailOrder.price}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div>
                        ------------------------------ <br>
                        Total: $${priceTotal}
                    </div>
                </div>

                <div class="text-center mt-5 mb-5">
                    <button class="btn btn-primary" href="/">Go Home</button>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- Footer -->
<%@include file="/common/web/footer.jsp" %>
</body>
</html>

