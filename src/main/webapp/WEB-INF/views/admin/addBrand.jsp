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
    <title>Add Brand</title>
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

                <form:form style="width: 100%" modelAttribute="brand" method="post" action="/admin/brand/added">
                <div class="col-sm-12" style="    height: 250px;    padding: 20px;">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*ID Brand: </label>
                        <div class="col-sm-6">
                            <form:input id="checkId" path="idBrand"/>
                            <span style="color: red" id="errId"></span>
                                <%--                        <input value="${brand.idBrand}" disabled>--%>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">*Name Brand</label>
                        <div class="col-sm-6">
                            <form:input path="nameBrand"/>
                        </div>
                    </div>
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

<script>
    $(function () {
        $('#checkId').keyup(function (e) {

            var id = $('#checkId').val();

            if (id.length != 0) {
                $.ajax({
                    url: '/admin/brand/checkId',
                    type: 'GET',
                    // enctype: 'multipart/form-data',
                    data: {
                        id: id
                    },
                    success: function (result) {
                        if (result) {
                            $('#errId').html("");
                        } else {
                            $('#errId').html("Id Brand is exist");
                        }
                        // $('#checkId').val("");
                    },
                    error: function (error) {
                        alert("Error")
                    }
                });
            }
        });
    });
</script>
</body>
</html>
