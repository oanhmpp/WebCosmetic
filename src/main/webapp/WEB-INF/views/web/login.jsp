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
            <%@include file="/common/web/login.jsp" %>
            <%--    register--%>
            </center>
        </div>

    </div>
</div>
<!-- Login End -->

<!-- Footer -->
<%@include file="/common/web/footer.jsp" %>
</body>
</html>
