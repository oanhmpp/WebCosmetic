<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <%@include file="/common/web/head.jsp"%>
</head>

<body>

<%@include file="/common/web/header.jsp"%>

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

<!-- Register Start -->
<div class="login ">
    <div class="container-fluid">
        <div class="row">
            <%--    register--%>
                <center>
            <%@include file="/common/web/register.jsp" %>
                </center>
            <%--    register--%>
        </div>
    </div>
</div>
<!-- Register End -->

<%@include file="/common/web/footer.jsp"%>

</body>
</html>
