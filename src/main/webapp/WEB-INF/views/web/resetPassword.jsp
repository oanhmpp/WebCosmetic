<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/13/2021
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/web/head.jsp" %>
</head>
<body>
<center>
    <div class="col-md-12" STYLE="padding: 20px">
        <h2>RESET PASSWORD</h2>
    </div>
<div class="container col-md-12">
    <form action="/reset-password", method="post">
    <div class="row justify-content-center">
        <div class="col-md-4" style="float: left">
            <label>New Password</label>
            <br>
            <label>Confirm Password</label>
        </div>
        <div class="col-md-4" style="float: right">
            <div class="form-group pass_show">
                <input name="pass" type="password" class="form-control">
            </div>
            <div class="form-group pass_show">
                <input name="rePass" type="password" class="form-control">
            </div>
        </div>
    </div>
    <div class="col-md-12">
        <button type="submit">Save</button>
    </div>
    </form>
</div>
</center>
</body>
</html>
