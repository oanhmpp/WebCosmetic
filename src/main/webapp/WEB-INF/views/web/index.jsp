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

<!-- Main Slider Start -->
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9">
                <div class="header-slider normal-slider">
                    <div class="header-slider-item">
                        <img height="400" width="900" src="<c:url value="/resources/web/img/Product/Slider/slider1.jpg"/>" alt="Slider Image"/>
                    </div>
                    <div class="header-slider-item">
                        <img height="400" width="900" src="<c:url value="/resources/web/img/Product/Slider/slider2.jpg"/>" alt="Slider Image"/>
                    </div>
                    <div class="header-slider-item">
                        <img height="400" width="900" src="<c:url value="/resources/web/img/Product/Slider/slider3.jpg"/>" alt="Slider Image"/>
                    </div>
                    <div class="header-slider-item">
                        <img height="400" width="900" src="<c:url value="/resources/web/img/Product/Slider/slider4.jpg"/>" alt="Slider Image"/>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="header-img">
                    <div class="img-item">
                        <img src="<c:url value="/resources/web/img/Product/Son/Romand/RomandMilkTeaVelvetTint/1.jpg"/>"/>
                    </div>
                    <div class="img-item">
                        <img src="<c:url value="/resources/web/img/Product/Son/Merzy/MerzyTheFirstVelvetTintSeason3(VerBlue)/1.jpg"/>"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Main Slider End -->

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

<!-- Call to Action Start -->
<div class="call-to-action">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-md-6">
                <h1>call us for any queries</h1>
            </div>
            <div class="col-md-6">
                <a href="tel:0123456789">+012-345-6789</a>
            </div>
        </div>
    </div>
</div>
<!-- Call to Action End -->

<!-- Featured Product Start -->
<div class="featured-product product">
    <div class="container-fluid">
        <div class="section-header">
            <h1>Featured Product</h1>
        </div>
        <div class="row">
            <c:forEach var="product" items="${listProduct}">
                <div class="col-lg-3"  style="margin-top: 10px;">
                    <div class="product-item">
                        <div class="product-title">
                            <a href="">${product.nameProduct}</a>
                            <div class="ratting">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                        <div class="product-image"  style="width: 284px;height: 284px">
                            <a href="<c:url value="/productDetail?idProduct=${product.idProduct}"/>">
                                <img  style="width: 345px;height: 310px;" src="<c:url value="${product.image}"/>" alt="Product Image">
                            </a>
                        </div>
                        <div class="product-price">
                            <h3><span>$</span>${product.price}</h3>
                            <a class="btn btnAddToCart"  href="">
                                <span hidden class="idProduct" >${product.idProduct}</span>
                                <i class="fa fa-shopping-cart"></i>Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- Featured Product End -->

<!-- Recent Product Start -->
<div class="recent-product product">
    <div class="container-fluid">
        <div class="section-header">
            <h1>Recent Product</h1>
        </div>
        <div class="row">
            <c:forEach var="product" items="${listProduct}">
                <div class="col-lg-3" style="margin-top: 10px;">
                    <div class="product-item">
                        <div class="product-title">
                            <a href="<c:url value="/productDetail?idProduct=${product.idProduct}"/>">${product.nameProduct}</a>
                            <div class="ratting">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                        <div class="product-image" style="width: 284px;height: 284px">
                            <a href="<c:url value="/productDetail?idProduct=${product.idProduct}"/>">
                                <img  style="width: 345px;height: 310px;" src="<c:url value="${product.image}"/>" alt="Product Image">
                            </a>
                        </div>
                        <div class="product-price">
                            <h3><span>$</span>${product.price}</h3>
                            <a class="btn btnAddToCart"  href=""><span hidden class="idProduct" >${product.idProduct}</span><i class="fa fa-shopping-cart"></i>Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- Recent Product End -->

<!-- Footer  -->
<%@include file="/common/web/footer.jsp" %>
</body>
</html>
