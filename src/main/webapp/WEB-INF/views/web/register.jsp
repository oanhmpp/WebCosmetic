<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>E Store - eCommerce HTML Template</title>
    <%@include file="/common/web/head.jsp"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--    <%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--    <%@include file="/resources/lib/ajaxRegistration.js" %>--%>

</head>

<body>

<%@include file="/common/web/header.jsp"%>

<%--<!-- Breadcrumb Start -->--%>
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Login & Register</li>
        </ul>
    </div>
</div>
<%--<!-- Breadcrumb End -->--%>

<!-- Register Start -->
<div class="login ">
    <div class="container-fluid">
        <div class="row d-flex justify-content-center">
            <%--    register--%>

                <div class="col-lg-6 ">
                    <div class="register-form">
                        <form:form modelAttribute="customer" method="post" action="/register">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Your name: </label>
                                    <form:input cssClass="form-control" path="nameCustomer" placeholder="Your name"/>
                                    <form:errors path="nameCustomer" cssStyle="color: red" cssClass="error"/>
                                </div>
                                <div class="col-md-6">
                                    <label>Your phone: </label>
                                    <form:input cssClass="form-control" path="phone" placeholder="Your phone"/>
                                    <form:errors path="phone" cssStyle="color: red" cssClass="error"/>
                                </div>
                                <div class="col-md-6">
                                    <label>Your Email: </label>
                                    <form:input cssClass="form-control" path="email" placeholder="Your Email"/>
                                    <span style="color: red" id="errId"></span>
<%--                                    <form:errors path="email"  cssStyle="color: red" cssClass="error"/>--%>
                                </div>
                                <div class="col-md-6">
                                    <label>Password: </label>
                                    <form:password cssClass="form-control" path="password" placeholder="Password"/>
                                    <form:errors path="password"  cssStyle="color: red" cssClass="error"/>
                                </div>
                                <div  class="col-md-6">
                                    <label></label>
                                    <form:hidden path="idCustomer"/>
                                </div>
                                <div class="col-md-6">
                                    <label>Retype Password</label>
                                    <form:password cssClass="form-control" path="rePass" placeholder="Retype Password" />
                                    <form:errors path="rePass"  cssStyle="color: red" cssClass="error"/>
                                </div>
                                <div class="col-md-12 d-flex justify-content-center">
                                    <form:button id="submit"  cssStyle="color: red" class="btn">Submit</form:button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>

            <%--    register--%>
        </div>
    </div>
</div>
<!-- Register End -->

<%@include file="/common/web/footer.jsp"%>

<script>
    // $(function () {
    //     $('#submit').keyup(function (e) {
    //
    //             $.ajax({
    //                 url: '/admin/brand/checkId',
    //                 type: 'GET',
    //                 // data: {
    //                 //     id: id
    //                 // }
    //                 // ,
    //                 success: function (result) {
    //                   alert("Success")
    //                 },
    //                 error: function (error) {
    //                     alert("Error")
    //                 }
    //             });
    //     });
    // });
</script>
</body>
</html>
