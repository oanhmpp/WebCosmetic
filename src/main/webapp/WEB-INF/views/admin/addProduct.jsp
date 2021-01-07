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
    <title>Add Product</title>
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

                <form:form style="width: 100%" modelAttribute="product" method="post" action="/admin/product/added">
                    <div class="col-sm-12" style="    height: 250px;    padding: 20px;">
                        <div class="col-sm-6" style="float: left">
                            <div class="form-group row">
<%--                                <label class="col-sm-4 col-form-label">*ID Product: </label>--%>
<%--                                <div class="col-sm-6">--%>
<%--                                    <form:input path="idProduct"/>--%>
<%--                                </div>--%>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">*Name Product</label>
                                <div class="col-sm-6">
                                    <form:input path="nameProduct"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-4 col-form-label">ID Brand</div>
                                <div class="col-sm-6">
                                    <form:select path="idBrand.idBrand">
                                        <c:forEach var="brand" items="${listBrand}">
                                            <option value="${brand.idBrand}">${brand.nameBrand}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">*ID Type:
                                </label>
                                <div class="col-sm-6">
                                    <form:select path="idType.idType">
                                        <c:forEach var="type" items="${listType}">
                                            <option value="${type.idType}">${type.nameType}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6" style="float: right">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Image</label>
                                <div class="col-sm-6">
                                    <div class="col-sm-12">
                                        <div style="float: left" class="col-sm-3">
                                            <img id="img_main" class="img_product" style="height: 50px; width: 50px"
                                                 src="${product.image}">
                                        </div>
                                            <%--                                        <c:forEach var="img" items="${arrImg}">--%>
                                        <div style="float: left" class="col-sm-3">
                                            <img id="img_detail_1" class="img_product" style="height: 50px; width: 50px"
                                                 src="${img}">
                                            <img id="img_detail_2" class="img_product" style="height: 50px; width: 50px"
                                                 src="${img}">
                                            <img id="img_detail_3" class="img_product" style="height: 50px; width: 50px"
                                                 src="${img}">
                                        </div>
                                            <%--                                        </c:forEach>--%>
                                        <form:hidden path="detailProductEntity.idProduct" required="required"/>
                                        <form:hidden id="input_image" path="image" required="required"/>
                                        <form:hidden id="input_image_detail" path="detailProductEntity.image"
                                                     required="required"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Amount</label>
                                <div class="col-sm-6">
                                    <form:input path="amount"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Active</label>
                                <div class="col-sm-6">
                                    <form:select path="active">
                                        <option value="1">Display</option>
                                        <option value="0">Not display</option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Description</label>
                                <div class="col-sm-6">
                                    <form:textarea cssStyle="height: 100px" path="detailProductEntity.description"/>
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
