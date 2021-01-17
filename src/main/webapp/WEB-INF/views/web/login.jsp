<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <li class="breadcrumb-item active">Login & Register</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Login Start -->
<div class="login">
    <div class="container-fluid">

        <div class="row" style="">
            <center>
                <%--    login--%>
                    <div class="col-lg-6">
                        <form name='f' method="post" action="/login">
                        <div class="login-form">
                            <div class="row d-flex justify-content-center">
                                <div class="col-md-6">
                                    <label>Your Email: </label>
                                    <input type='text' name='email' value=''>
                                </div>
                                <div class="col-md-6">
                                    <label>Password: </label>
                                    <input type='password' name='password' />
                                </div>
                                <div class="col-md-12">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox"  name="remember-me" class="custom-control-input" id="newaccount">
<%--                                        name là mặc định--%>
                                        <label class="custom-control-label" for="newaccount">Keep me signed in</label>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <input name="submit" type="submit" value="submit" />
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>                <%--    register--%>
            </center>
        </div>

    </div>
</div>
<!-- Login End -->

<!-- Footer -->
<%@include file="/common/web/footer.jsp" %>
</body>
</html>
