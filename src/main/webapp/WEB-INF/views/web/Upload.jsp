<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/6/2021
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/web/head.jsp" %>
</head>
<body>
<form id="formUpload" enctype="multipart/form-data" action="uploadpath" method="post">
    <input type="file" name="file" id="fileUpload"/>
</form>

<img id="imgUpload" src="" width="200px" height="200px">

<iframe id="frmUpload" name="frmUpload" style="display: none;"></iframe>
</body>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $('#fileUpload').change(function (e) {
            e.preventDefault();

            var form = $('#formUpload')[0];
            var formData = new FormData(form);
            $.ajax({
                url: '/uploadpath',
                type: 'POST',
                enctype: 'multipart/form-data',
                data: formData,
                contentType: false,
                processData: false,
                success: function (result) {
                    $('#imgUpload').attr('src', result);
                },
                error: function (error) {
                    alert("Lỗi hệ thống ");
                }
            });
        });
    });

</script>
</html>
