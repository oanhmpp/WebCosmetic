<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/12/2021
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <%@include file="/common/admin/head.jsp"%>
</head>
<body>
<div class="loader"></div>
<div id="app">
    <div class="main-wrapper main-wrapper-1">
        <div class="navbar-bg"></div>
        <%--      Header    --%>
        <%@include file="/common/admin/header.jsp" %>
        <%--      Header    --%>

        <%--  Menu    --%>
        <%@include file="/common/admin/menu.jsp" %>
        <%--  Menu    --%>
        <!-- Main Content -->
        <div class="main-content">
            <section class="section">
                <div class="section-body">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Basic DataTables</h4>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped" id="table-1">
                                            <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name Customer</th>
                                                <th>Address</th>
                                                <th>Phone</th>
                                                <th>Product</th>
                                                <th>Price Total</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <p>
                                                Total Product: <b id="total">${orderList.size()}</b>
                                            </p>
                                            <c:forEach var="order" items="${orderList}">
                                                <tr>
                                                    <td>${order.idOrder}</td>
                                                    <td>
                                                        <security:authentication property="principal.customer.nameCustomer"/>
                                                    </td>
                                                    <td>${order.address}</td>
                                                    <td>0${order.phone}</td>
                                                    <td>
                                                        <c:forEach var="detailOrder" items="${detailOrderList}">
                                                            <c:if test="${detailOrder.order.idOrder==order.idOrder}">
                                                                <p>${detailOrder.nameProduct} <span>(${detailOrder.amount})</span></p>
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <td>${order.totalPrice}</td>
                                                <%--                                                    <td><a href="/admin/">Show detail</a></td>--%>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <footer class="main-footer">
        <div class="footer-left">
            <a href="">Templateshub</a></a>
        </div>
        <div class="footer-right">
        </div>
    </footer>
</div>
</div>
<!-- General JS Scripts -->
<script src="<c:url value="/resources/admin/assets/js/app.min.js"/>"></script>
<!-- JS Libraies -->
<script src="<c:url value="/resources/admin/assets/bundles/datatables/datatables.min.js"/>"></script>
<script src="<c:url
        value="/resources/admin/assets/bundles/datatables/DataTables-1.10.16/js/dataTables.bootstrap4.min.js"/>"></script>
<script src="<c:url value="/resources/admin/assets/bundles/jquery-ui/jquery-ui.min.js"/>"></script>
<!-- Page Specific JS File -->
<script src="<c:url value="/resources/admin/assets/js/page/datatables.js"/>"></script>
<!-- Template JS File -->
<script src="<c:url value="/resources/admin/assets/js/scripts.js"/>"></script>
<!-- Custom JS File -->
<script src="<c:url value="/resources/admin/assets/js/custom.js"/>"></script>
</body>
</html>
