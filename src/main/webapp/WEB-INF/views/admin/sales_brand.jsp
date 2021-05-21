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
    <title>Title</title>
    <%@include file="/common/admin/head.jsp" %>
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
            <label>Choose time: </label>
            <input style="width: 170px" type="text" name="daterange" value="01/01/2020 - 01/15/2021"/>
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
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
    var startDate = moment().subtract(1,'months')
    var endDate = moment();
    $('input[name="daterange"]').daterangepicker({
        showDropdowns: true,
        opens: 'right',
        startDate: startDate,
        maxDate: endDate,
    }, function (start, end, label) {
        revenueBrand(start.format('YYYY-MM-DD'), end.format('YYYY-MM-DD'));
    });
    window.onload = function () {
        salesBrand(startDate.format('YYYY-MM-DD'),endDate.format('YYYY-MM-DD'));
    }
    $(function () {
        $('input[name="daterange"]').daterangepicker({
            opens: 'right'
        }, function (start, end, label) {
            var year1 = start.format('YYYY-MM-DD');
            var year2 = end.format('YYYY-MM-DD');
            salesBrand(year1, year2);
            // alert("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        });
    });

    function salesBrand(year1, year2){
        $.ajax({
            url: '/admin/sales/salesByBrand',
            type: 'POST',
            data: {
                year1: year1,
                year2: year2
            },
            success: function (result) {
                console.log(result)
                var dataChart = [];
                $.each(result, function (index, value) {
                    dataChart[index] = {
                        label: value[0],
                        y: value[1]
                    }
                });


                var chart = new CanvasJS.Chart("chartContainer", {
                    title: {
                        text: "Sales by brand"
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
</body>
</html>
