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
                    <div class="col-md-12">
                        <div class="product-view-top">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="product-search">
                                        <input type="email" value="Search">
                                        <button><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-short">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown">Product short by</div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">Newest</a>
                                                <a href="#" class="dropdown-item">Popular</a>
                                                <a href="#" class="dropdown-item">Most sale</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="product-price-range">
                                        <div class="dropdown">
                                            <div class="dropdown-toggle" data-toggle="dropdown">Product price range
                                            </div>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a href="#" class="dropdown-item">$0 to $50</a>
                                                <a href="#" class="dropdown-item">$51 to $100</a>
                                                <a href="#" class="dropdown-item">$101 to $150</a>
                                                <a href="#" class="dropdown-item">$151 to $200</a>
                                                <a href="#" class="dropdown-item">$201 to $250</a>
                                                <a href="#" class="dropdown-item">$251 to $300</a>
                                                <a href="#" class="dropdown-item">$301 to $350</a>
                                                <a href="#" class="dropdown-item">$351 to $400</a>
                                                <a href="#" class="dropdown-item">$401 to $450</a>
                                                <a href="#" class="dropdown-item">$451 to $500</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <c:forEach var="product" items="${listProduct}">
                        <div class="col-md-4">
                            <div class="product-item">
                                <div class="product-title">
                                    <a href="#">${product.nameProduct}</a>
                                </div>
                                <div class="product-image"  style="width: 284px;height: 284px">
                                    <a href="<c:url value="/productDetail?idProduct=${product.idProduct}"/>">
                                        <img src="<c:url value="${product.image}"/>"
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
            <div class="brand-item"><img src="<c:url value="/resources/web/img/brand-1.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/brand-2.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/brand-3.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/brand-4.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/brand-5.png"/>" alt=""></div>
            <div class="brand-item"><img src="<c:url value="/resources/web/img/brand-6.png"/>" alt=""></div>
        </div>
    </div>
</div>
<!-- Brand End -->

<%@include file="/common/web/footer.jsp" %>
</body>
</html>
