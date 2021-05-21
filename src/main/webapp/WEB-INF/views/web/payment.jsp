<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<div class="container-fluid">
    <div style="padding: 30px" class="row d-flex justify-content-center">
        <%--    payment--%>

        <div class="col-lg-6 ">
            <div class="register-form">
                <form:form modelAttribute="order" method="post" action="/payment/detailOrder">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Your name: </label>
                           <p style="padding-top: 5px;" class="form-control"><security:authentication property="principal.username"/></p>
                        </div>
                        <div class="col-md-6">
                            <label>Your phone: </label>
                            <c:set var="phone">
                                <security:authentication property="principal.customer.phone"/>
                            </c:set>
                            <form:input  cssClass="form-control" path="phone"  value="${phone}"/>
                            <form:errors path="phone" cssStyle="color: red" cssClass="error"/>
                        </div>
                            <form:hidden path="idOrder"/>
                        <div class="col-md-6">
                            <label>Your address: </label>
                            <form:input cssClass="form-control" path="address" placeholder="Your address..."/>
                            <form:errors path="address" cssStyle="color: red" cssClass="error"/>
                        </div>
                        <div class="col-md-6">
                            <label>Total price: </label>
                            <input hidden path="${priceTotal}"/>
                            <form:input disabled="true" path="totalPrice" class="form-control" value="${priceTotal}" />
                        </div>
                        <div style="padding: 20px;" class="col-md-12 d-flex justify-content-center">
                            <form:button id="submit"  cssStyle="color: red" class="btn">Payment on delivery</form:button>
                            <form:button id="onl-pay"  cssStyle="color: red" class="btn">Online payment</form:button>
                        </div>
                        <form:hidden path="customerEntity.idCustomer"/>
                    </div>
                </form:form>
            </div>
        </div>

        <%--    payment--%>
    </div>
</div>

<!-- Footer -->
<%@include file="/common/web/footer.jsp" %>
</body>
</html>
