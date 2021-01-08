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

                <form:form style="width: 100%" modelAttribute="product" method="post" action="/admin/product/edit">
                    <div class="col-sm-12" style="    height: 440px;    padding: 20px;">
                        <div class="col-sm-6" style="float: left">
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*Name Product</label>
                                <form:input path="nameProduct" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*ID Brand</label>
                                <form:select path="idBrand.idBrand" cssClass="form-control">
                                    <c:forEach var="brand" items="${listBrand}">
                                        <option value="${brand.idBrand}">${brand.nameBrand}</option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*Image</label>
                                <div class="d-flex justify-content-center" style="width: 100%;">
                                        <div class="d-flex " style="width: 100%">
                                        <div style="margin-right: 10px" class="">
                                            <img id="img_main" class="img_product" style="height: 60px; width: 60px"
                                                 src="${product.image}">
                                        </div>
                                            <%--                                        <c:forEach var="img" items="${arrImg}">--%>
                                        <div style="margin-right: 10px" class="">
                                            <img id="img_detail_1" class="img_product" style="height: 60px; width: 60px"
                                                 src="${arrImg1}">
                                        </div>
                                        <div style="margin-right: 10px" class="">
                                            <img id="img_detail_2" class="img_product" style="height: 60px; width: 60px"
                                                 src="${arrImg2}">
                                        </div>
                                        <div style="margin-right: 10px" class="">
                                            <img id="img_detail_3" class="img_product" style="height: 60px; width: 60px"
                                                 src="${arrImg3}">
                                        </div>
                                            <%--                                        </c:forEach>--%>
                                        <form:hidden path="detailProductEntity.idProduct" required="required"/>
                                        <form:hidden path="idProduct" required="required"/>
                                        <form:hidden id="input_image" path="image" required="required"/>
                                        <form:hidden id="input_image_detail" path="detailProductEntity.image"
                                                     required="required"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*Price</label>
                                <form:input path="price" cssClass="form-control"/>
                            </div>
                        </div>

                        <div class="col-sm-6" style="float: left">
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*Amount</label>
                                <form:input path="amount" cssClass="form-control"/>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*Active</label>
                                <form:select path="active" cssClass="form-control">
                                    <option value="1">Display</option>
                                    <option value="0">Not display</option>
                                </form:select>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-form-label">*Description</label>
                                <form:textarea cssClass="form-control" rows="10" path="detailProductEntity.description"/>
                            </div>

                        </div>
                    </div>

                    <div class="col-sm-12">
                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">*ID Type:
                            </label>
                            <div class="form-control" style="    height: 100%;">
                                <c:forEach var="type" items="${listType}">
                                    <c:forEach var="typeProduct" items="${product.idType}">
                                        <c:if test="${type.idType==typeProduct.idType}">
                                          <input checked type="checkbox" class="custom-checkbox" name="type" style="margin-left: 20px"
                                          value="${type.idType}">${type.nameType}
                                        </c:if>
                                        <c:if test="${type.idType!=typeProduct.idType}">
                                            <input type="checkbox" class="custom-checkbox" name="type" style="margin-left: 20px"
                                                   value="${type.idType}">${type.nameType}
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
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
