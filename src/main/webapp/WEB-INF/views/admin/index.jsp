<!DOCTYPE html>
<html lang="en">


<!-- index.jsp  21 Nov 2019 03:44:50 GMT -->
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
    <title>Admin</title>
    <!-- General CSS Files -->
    <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/app.min.css"/>">
    <!-- Template CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/components.css"/>">
    <!-- Custom style CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/custom.css"/>">
</head>

<body>
<div class="loader"></div>
<div id="app">
    <div class="main-wrapper main-wrapper-1">
        <%--      Header    --%>
        <%@include file="/common/admin/header.jsp" %>
        <%--      Header    --%>

        <%--  Menu    --%>
        <%@include file="/common/admin/menu.jsp" %>
        <%--  Menu    --%>
        <!-- Main Content -->
        <div class="main-content d-flex justify-content-center">
         <h1>WELCOME TO ADMIN ^^</h1>
        </div>
        <%--       Footer       --%>
        <%@include file="/common/admin/footer.jsp" %>
        <%--       Footer       --%>
    </div>
</div>
<!-- General JS Scripts -->
<script src="<c:url value="/resources/admin/assets/js/app.min.js"/>"></script>
<!-- JS Libraies -->
<script src="<c:url value="/resources/admin/assets/bundles/apexcharts/apexcharts.min.js"/>"></script>
<!-- Page Specific JS File -->
<script src="<c:url value="/resources/admin/assets/js/page/index.js"/>"></script>
<!-- Template JS File -->
<script src="<c:url value="/resources/admin/assets/js/scripts.js"/>"></script>
<!-- Custom JS File -->
<script src="<c:url value="/resources/admin/assets/js/custom.js"/>"></script>
</body>
<!-- index.jsp  21 Nov 2019 03:47:04 GMT -->
</html>