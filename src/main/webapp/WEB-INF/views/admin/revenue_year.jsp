<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/19/2021
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/admin/head.jsp" %>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script type="text/javascript">

        window.onload = function () {
            revenueYear(new Date().getUTCFullYear());

            $('#year').val(new Date().getUTCFullYear());
            $('#year').on('change', function () {
                revenueYear(this.value);
            });
        }

        function revenueYear(year) {
            $.ajax({
                url: '/admin/revenue/revenueByYear',
                type: 'POST',
                data: {
                    year: year
                },
                success: function (result) {

                    var dataChart = [];
                    $.each(result, function (index, value) {
                        dataChart[index] = {
                            label: value[0],
                            y: value[1]
                        }
                    });


                    var chart = new CanvasJS.Chart("chartContainer", {
                        title: {
                            text: "Revenue by year"
                        },
                        data: [
                            {
                                type: "column",
                                dataPoints: dataChart
                            }
                        ]
                    });
                    chart.render();
                },
                error: function (error) {
                    alert("Error")
                }
            });

        }
    </script>
    <title>Title</title>
</head>
<body>
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
            <label>Choose a year:</label>
            <select id="year" name="year">
                <c:forEach var="order" items="${listYear}">
                    <option value="${order}">${order}</option>
                    <%--                    <option value=""><fmt:formatDate pattern="yyyy" value="${order.date}"/></option>--%>
                </c:forEach>
            </select>
            <div id="chartContainer" style="height: 300px; width: 100%;"></div>
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
