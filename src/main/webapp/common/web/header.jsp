<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Top bar Start -->
<div class="top-bar">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6">
                <i class="fa fa-envelope"></i>
                support@email.com
            </div>
            <div class="col-sm-6">
                <i class="fa fa-phone-alt"></i>
                +012-345-6789
            </div>
        </div>
    </div>
</div>
<!-- Top bar End -->

<!-- Nav Bar Start -->
<div class="nav">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a href="#" class="navbar-brand">MENU</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav mr-auto">
                    <a href="<c:url value="/"/>" class="nav-item nav-link active">Home</a>
                    <a href="<c:url value="/product"/>" class="nav-item nav-link">Products</a>
                    <a href="<c:url value="/cart"/>" class="nav-item nav-link ">Cart</a>
                    <a href="<c:url value="/myAccount"/>" class="nav-item nav-link">My Account</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>
                        <div class="dropdown-menu">
                            <a href="<c:url value="/contact"/>" class="dropdown-item">Contact Us</a>
                        </div>
                    </div>
                </div>

                <%--                <c:if test="${userDetail==null}">--%>
                <security:authorize access="isAnonymous()">
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">User Account</a>
                            <div class="dropdown-menu">
                                <a href="<c:url value="/login"/>" class="dropdown-item">Login</a>
                                <a href="<c:url value="/register"/>" class="dropdown-item">Register</a>
                            </div>
                        </div>
                    </div>
                </security:authorize>
                <%--                </c:if>--%>
                <%--                <c:if test="${userDetail!=null}">--%>
                <security:authorize access="isAuthenticated()">
                    <div class="navbar-nav ml-auto">
                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown">
                                <security:authentication property="principal.customer.nameCustomer"/>
                                    <%--                                    ${userDetail.getUsername()}--%>
                            </a>
                            <div class="dropdown-menu">
                                <c:if test="${userDetail.isAdmin()}">
                                    <a class="dropdown-item" href="/admin">
                                        ADMIN
                                    </a>
                                </c:if>
                                <c:if test="${!userDetail.isAdmin()}">
                                    <a href="/myAccount" class="dropdown-item">
                                        My account
                                    </a>
                                </c:if>
                                <a href="<c:url value="/logout"/>"
                                   class="dropdown-item"><i class="fas fa-sign-out-alt"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </security:authorize>

                <%--                </c:if>--%>


            </div>
        </nav>
    </div>
</div>
<!-- Nav Bar End -->

<!-- Bottom Bar Start -->
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-md-3">
                <div class="logo">
                    <a href="/">
                        <img src="<c:url value="/resources/web/img/logo.png"/>" alt="Logo">
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <form action="/searchListProduct">
                <div class="search">
                    <input autocomplete="off" class="key" id="textFind" name="search" type="text" placeholder="Search">
                    <button class="btn_find"><i class="fa fa-search"></i></button>
                </div>
                </form>
                <div style="    position: absolute;    z-index: 2;">
                    <ul style="z-index: -1" id="f" class="list-group">
                    </ul>
                </div>
            </div>
            <div class="col-md-3">
                <div class="user">
                    <a href="<c:url value="/cart"/>" class="btn cart btn_cart">
                        <i class="fa fa-shopping-cart"></i>
                        <span id="numberProduct"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bottom Bar End -->
