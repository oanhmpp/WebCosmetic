<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/5/2021
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
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
            <center>
                <form id="formUpload" enctype="multipart/form-data" action="uploadpath" method="post">
                    <input type="file" name="file" id="fileUpload" style="visibility: hidden"/>
                </form>

                <form:form style="width: 100%" modelAttribute="customer" method="post" action="/admin/brand/edit">
                <div class="col-sm-12" style="    height: 250px;    padding: 20px;">
                    <div style="float: left" class="col-sm-6">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*ID Customer: </label>
                        <div class="col-sm-6">
                            <form:hidden path="idCustomer"/>
                            <input value="${customer.idCustomer}" disabled>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*Name Customer</label>
                        <div class="col-sm-6">
                            <form:input path="nameCustomer"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*Email</label>
                        <div class="col-sm-6">
                            <form:input path="email"/>
                        </div>
                    </div>
                    </div>
                    <div class="col-sm-6" style="float: right">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*Password</label>
                        <div class="col-sm-6">
                            <form:input path="password"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*Role</label>
                        <div class="col-sm-6">
                            <form:select path="roleEntityList">
                                <option value="1">Admin</option>
                                <option value="0"></option>
                            </form:select>
                        </div>
                    </div>
                    <                                                                   /div>
                    <div class="col-sm-12 d-flex justify-content-center">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="submit" value="OK"/>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        </form:form>
        </center>
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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

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
<script src="<c:url value="/resources/js/admin_js.js"/>"></script>

</body>
</html>
