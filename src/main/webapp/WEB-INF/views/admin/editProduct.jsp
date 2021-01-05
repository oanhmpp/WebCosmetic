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
    <title>Edit Product</title>
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
            <center>
                <form:form style="width: 100%" modelAttribute="product" method="post" action="/admin/editedProduct" >
                    <div class="col-sm-12" style="    height: 250px;    padding: 20px;">
                        <div class="col-sm-6" style="float: left">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">*ID Product: </label>
                                <div class="col-sm-6">
                                    <form:input path="idProduct"/>
                                    <!-- <input type="text" class="form-control" name="idStudent"
                                        placeholder="StudentID"> -->
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">*Name Product</label>
                                <div class="col-sm-6">
                                    <form:input path="nameProduct"/>
                                    <!-- <input type="text" class="form-control" name="nameStudent"
                                        placeholder="Name"> -->
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-4 col-form-label">ID Brand</div>
                                <div class="col-sm-6">
                                    <form:select path="idBrand" >
                                        <option value="Tin">Tin học</option>
                                        <option value="Anh">Anh Văn</option>
                                        <option value="Vat">Vật lí</option>
                                        <option value="Kinh">Kinh tế</option>
                                        <option value="Sinh">Sinh vật học</option>
                                        <option value="Hoa">Hóa học</option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">*ID Type:
                                </label>
                                <div class="col-sm-6">
                                    <form:select path="idType" >
                                        <option value="Tin">Tin học</option>
                                        <option value="Anh">Anh Văn</option>
                                        <option value="Vat">Vật lí</option>
                                        <option value="Kinh">Kinh tế</option>
                                        <option value="Sinh">Sinh vật học</option>
                                        <option value="Hoa">Hóa học</option>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6" style="float: right">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Image</label>
                                <div class="col-sm-6">
                                    <form:input path="image" />
                                    <!-- <input type="text" class="form-control" name="placeBirth"
                                        placeholder="Place of birth"> -->
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Amount</label>
                                <div class="col-sm-6">
                                    <form:input path="amount" />
                                    <!-- <input type="password" class="form-control" id="address"
                                        placeholder="Address"> -->
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Active</label>
                                <div class="col-sm-6">
                                    <form:select path="active" >
                                        <option value="0">Display</option>
                                        <option value="1">Not display</option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Description</label>
                                <div class="col-sm-6">
                                    <form:input path="detailProductEntity.description" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 d-flex justify-content-center">
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <input type="submit" value="OK"/>
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
