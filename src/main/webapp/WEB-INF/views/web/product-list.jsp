<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li class="breadcrumb-item active">Product List</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Product List Start -->
<div class="product-view">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="row">
                    <c:forEach var="product" items="${listProduct}">
                        <div class="col-md-3">
                            <div class="product-item">
                                <div class="product-title">
                                    <a href="<c:url value="/productDetail?idProduct=${product.idProduct}"/>">${product.nameProduct}</a>
                                </div>
                                <div class="product-image"  style="width: 284px;height: 284px">
                                    <a href="<c:url value="/productDetail?idProduct=${product.idProduct}"/>">
                                        <img style="width: 345px;height: 310px;" src="<c:url value="${product.image}"/>"
                                             alt="Product Image">
                                    </a>
                                </div>
                                <div class="product-price">
                                    <h3><span>$</span>${product.price}</h3>

                                    <a class="btn btnAddToCart"  href=""> <span hidden class="idProduct" >${product.idProduct}</span><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <!-- Pagination Start -->
                <div class="col-md-12">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <!-- Pagination Start -->
            </div>
        </div>
    </div>
</div>
<!-- Product List End -->

<!-- Brand Start -->
<div class="brand">
    <div class="container-fluid">
        <div class="brand-slider">
            <div class="brand-item"><img src="<c:url value="/resources/web/img/Product/Brand/brand1.jpg"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/Product/Brand/brand2.jpg"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/Product/Brand/brand3.jpg"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/Product/Brand/brand4.jpg"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/Product/Brand/brand5.jpg"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/Product/Brand/brand6.jpg"/>" alt=""></div>
        </div>
    </div>
</div>
<!-- Brand End -->

<%@include file="/common/web/footer.jsp" %>
</body>
</html>
