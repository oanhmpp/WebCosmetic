<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/5/2021
  Time: 2:12 PM
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
                                                <th class="text-center">
                                                    #
                                                </th>
                                                <th>Name Product</th>
                                                <th>ID Brand</th>
                                                <th>ID Type</th>
                                                <th>Image</th>
                                                <th>Amount</th>
                                                <th>Price</th>
                                                <th>Active</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <p>
                                                Total Product: <b id="total">${listProduct.size()}</b>
                                            </p>
                                            <c:forEach var="product" items="${listProduct}">
                                            <tr>
                                                <td>${product.idProduct }</td>
                                                <td>${product.nameProduct }</td>
                                                <td>${product.idBrand.idBrand }</td>
<%--                                                <td>${product.idType.get(0).idType }</td>--%>
                                                <td>
                                                    <img alt="image" src="${product.image }" width="35">
                                                </td>
                                                <td>${product.amount }</td>
                                                <td>${product.price }</td>
                                                <td>
                                                    <div class="d-flex justify-content-center">
                                                    <c:if test="${product.active == 1}">
                                                    <i style=" color:#007ddc;font-size: 25px; margin-right: 0px" class="fas fa-check-circle"></i>
                                                    </c:if>

                                                    <c:if test="${product.active == 0}">
                                                    <i style="font-size: 25px; margin-right: 0px" class="fas fa-minus-circle"></i>
                                                    </c:if>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex justify-content-center">
                                                        <a href="${pageContext.request.contextPath}/admin/product/edit?idProduct=${product.idProduct}"><i class="fas fa-pen"></i></a>
                                                    </div></td>
                                                <td>
                                                    <div class="d-flex justify-content-center">
                                                        <a onclick="return confirm('Do you want to delete ?')" href="${pageContext.request.contextPath}/admin/product/delete?idProduct=${product.idProduct}"><i class="fas fa-trash"></i></a>
                                                    </div></td>
                                            </tr>
                                            </c:forEach>
                                            </tbody>
                                            <div class="col-md-12">
                                                <a href="${pageContext.request.contextPath}/admin/product/add" style="    color: white;    float: right;
                                                    margin-left: 100px;    background: #007ddc;    padding: 10px;">Add product</a>
                                            </div>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <footer class="main-footer">
            <div class="footer-left">
                <a href="templateshub.net">Templateshub</a></a>
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
