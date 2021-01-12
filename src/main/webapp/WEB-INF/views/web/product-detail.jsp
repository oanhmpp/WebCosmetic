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
>

<!-- Product Detail Start -->
<div class="product-detail">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12" style="height: 100%">
                <div class="product-detail-top" style="    height: 1000px;">
                    <div class="row align-items-center">
                        <div class="col-md-5">
                            <div class="product-slider-single normal-slider">
                                <c:forEach var="img" items="${arrImg}">
                                    <img src="${img}" alt="Product Image">
                                </c:forEach>
                            </div>
                            <div class="product-slider-single-nav normal-slider">
                                <c:forEach var="img" items="${arrImg}">
                                    <div class="slider-nav-img"><img src="${img}" alt="Product Image"/></div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="col-md-7" style="margin-bottom: 550px;">
                            <div class="product-content">
                                <div class="title">
                                    <h2>${product.nameProduct}</h2>
                                </div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">
                                    <h4>Price:</h4>
                                    <p>$${product.price}</p>
                                </div>
                                <div class="p-size">
                                    <h4>Color:</h4>
                                    <div class="btn-group btn-group-sm">
                                        <c:forEach var="type" items="${product.idType}">
                                            <button type="button" id="idType" class="btn">${type.nameType}</button>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="action">
                                    <a class="btn" class="btnAddToCart" href=""><span hidden class="idProduct" >${product.idProduct}</span><i class="fa fa-shopping-cart"></i>Add to
                                        Cart</a>

                                    <a class="btn btnBuyNow" href=""><i
                                            class="fa fa-shopping-bag"></i>Buy Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row product-detail-bottom">
                    <div class="col-lg-12">
                        <ul class="nav nav-pills nav-justified">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="pill" href="#description">Description</a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div id="description" class="container tab-pane active">
                                <p style="font-size: 30px">
                                    ${productDetail.description}
                                </p>
                            </div>
                            <div id="specification" class="container tab-pane fade">
                                <h4>Product specification</h4>
                                <ul>
                                    <li>Lorem ipsum dolor sit amet</li>
                                    <li>Lorem ipsum dolor sit amet</li>
                                    <li>Lorem ipsum dolor sit amet</li>
                                    <li>Lorem ipsum dolor sit amet</li>
                                    <li>Lorem ipsum dolor sit amet</li>
                                </ul>
                            </div>
                            <div id="reviews" class="container tab-pane fade">
                                <div class="reviews-submitted">
                                    <div class="reviewer">Phasellus Gravida - <span>01 Jan 2020</span></div>
                                    <div class="ratting">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <p>
                                        Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium
                                        doloremque laudantium, totam rem aperiam.
                                    </p>
                                </div>
                                <div class="reviews-submit">
                                    <h4>Give your Review:</h4>
                                    <div class="ratting">
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                    <div class="row form">
                                        <div class="col-sm-6">
                                            <input type="text" placeholder="Name">
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="email" placeholder="Email">
                                        </div>
                                        <div class="col-sm-12">
                                            <textarea placeholder="Review"></textarea>
                                        </div>
                                        <div class="col-sm-12">
                                            <button>Submit</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="product">
                    <div class="section-header">
                        <h1>Related Products</h1>
                    </div>

                    <div class="row align-items-center product-slider product-slider-3">

                        <c:forEach var="proRandom" items="${productRandom}">
                            <div class="col-lg-3">
                                <div class="product-item">
                                    <div class="product-title">
                                        <a href="">${proRandom.nameProduct}</a>
                                        <div class="ratting">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="product-image">
                                        <a href="<c:url value="/productDetail?idProduct=${proRandom.idProduct}"/>">
                                            <img src="<c:url value="${proRandom.image}"/>"
                                                 alt="Product Image">
                                        </a>
                                    </div>
                                    <div class="product-price">
                                        <h3><span>$</span>${proRandom.price}</h3>
                                        <a class="btn btnBuyNow" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- Product Detail End -->

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
