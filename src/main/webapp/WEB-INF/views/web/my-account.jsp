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

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">My Account</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- My Account Start -->
<div class="my-account">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="nav flex-column nav-pills" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="dashboard-nav" data-toggle="pill" href="/myAccount" role="tab"><i
                            class="fa fa-tachometer-alt"></i>Profile detail</a>
                    <a class="nav-link" id="orders-nav" data-toggle="pill" href="myAccount/myAccountOrder" role="tab"><i
                            class="fa fa-shopping-bag"></i>Orders</a>
                    <a class="nav-link" href="/logout"><i class="fa fa-sign-out-alt"></i>Logout</a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="tab-content">
                    <%--                    <div class="row">--%>
                    <form:form style="width: 100%" modelAttribute="myAccount" method="post"
                               action="/myAccount/edit">
                        <div class="col-sm-12 d-flex justify-content-center">
                            <div class="col-sm-12">
                                <div class="col-sm-12 d-flex justify-content-center form-group">
                                    <label class="col-sm-4 col-form-label">*Name :</label>
                                    <div class="col-sm-6">
                                        <form:input cssClass="form-control" path="nameCustomer"/>
                                        <form:errors path="nameCustomer" cssStyle="color: red" cssClass="error"/>
                                    </div>
                                </div>
                                <div class="col-sm-12 d-flex justify-content-center form-group">
                                    <label class="col-sm-4 col-form-label">*Email :</label>
                                    <div class="col-sm-6">
                                        <form:input cssClass="form-control" path="email"/>
                                        <form:errors path="email" cssStyle="color: red" cssClass="error"/>
                                    </div>
                                </div>
                                <div class="col-sm-12 d-flex justify-content-center form-group">
                                    <label class="col-sm-4 col-form-label">*Phone :</label>
                                    <div class="col-sm-6">
                                        <form:input cssClass="form-control" path="phone"/>
                                        <form:errors path="phone" cssStyle="color: red" cssClass="error"/>
                                    </div>
                                </div>
                                <div class="col-sm-12 d-flex justify-content-center form-group">
                                    <label class="col-sm-4 col-form-label">*Password : </label>
                                    <div class="col-sm-6">
                                        <form:password cssClass="form-control" path="password"/>
                                        <form:errors path="password" cssStyle="color: red" cssClass="error"/>
                                    </div>
                                </div>
                                <div class="col-sm-12 d-flex justify-content-center form-group">
                                    <label class="col-sm-4 col-form-label">* Re Password :</label>
                                    <div class="col-sm-6">
                                        <form:input cssClass="form-control" path="rePass"/>
                                        <form:errors path="rePass" cssStyle="color: red" cssClass="error"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 d-flex justify-content-center">
                            <form:button id="submit" cssStyle="color: red" class="btn">Save</form:button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--</div>--%>
<!-- My Account End -->

<%--<%@include file="/common/web/footer.jsp" %>--%>

</body>
</html>
