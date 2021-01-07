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
    <%@include file="/common/admin/head.jsp" %>
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
                                                <th>ID Brand</th>
                                                <th>Name Brand</th>
                                                <th>Edit</th>
                                                <th>Delete</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <p>
                                                Total Product: <b id="total">${listBrand.size()}</b>
                                            </p>
                                            <c:forEach var="brand" items="${listBrand}">
                                                <tr>
                                                    <td>${brand.idBrand }</td>
                                                    <td>${brand.nameBrand }</td>
                                                    <td>
                                                            <%--                                                        <div class="d-flex justify-content-center">--%>
                                                        <a href="${pageContext.request.contextPath}/admin/brand/edit?idBrand=${brand.idBrand}"><i
                                                                class="fas fa-pen"></i></a>
                                                            <%--                                                        </div>--%>
                                                    </td>
                                                    <td>
                                                            <%--                                                        <div class="d-flex justify-content-center">--%>
                                                        <a onclick="return confirm('Do you want to delete ?')"
                                                           href="${pageContext.request.contextPath}/admin/brand/delete?idBrand=${brand.nameBrand}"><i
                                                                class="fas fa-trash"></i></a>
                                                            <%--                                                        </div>--%>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                            <div class="col-md-12">
                                                <a href="${pageContext.request.contextPath}/admin/brand/add" style="    color: white;    float: right;
                                                    margin-left: 100px;    background: #007ddc;    padding: 10px;">Add
                                                    Brand</a>
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
