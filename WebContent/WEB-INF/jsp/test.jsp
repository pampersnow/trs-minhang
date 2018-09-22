<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  	<script src="http://apps.bdimg.com/libs/jquery/1.7.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script> -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/site/css/jquery-ui.min.css"> 
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/jquery.min.js">
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="jqueryui/style.css">
</head>

<body>
    <select id="select">
        <option value='all'>全部</option>
        <option value='7'>最近7天</option>
        <option value='30'>最近一个月</option>
        <option value='183'>最近半年</option>
        <option value='365'>最近一年</option>
    </select>
    <p>开始：<input id="start" class="Wdate"	placeholder="请选择日期" type="text" name="startTime"
								onclick="WdatePicker()" /></p>
    <p>结束：<input type="text" id="stop"></p>
    <script>
        $(function () {
        	console.info($("#start"));
            $("#start,#stop").datepicker({
                showButtonPanel: true,
                dateFormat: "yy-mm-dd",
                defaultDate: +0,
            });
            var date = $.datepicker.formatDate("yy-mm-dd", new Date());
            $('#select').change(function (e) {
                var val = $(this).val();
                switch (val) {
                    case 'all':
                        $('#start').datepicker('setDate', '');
                        $('#stop').datepicker('setDate', '');
                        break;
                    case '7':
                        $('#start').datepicker('setDate', '-7');
                        $('#stop').datepicker('setDate', date);
                        break;
                    case '30':
                        $('#start').datepicker('setDate', "-30");
                        $('#stop').datepicker('setDate', date);
                        break;
                    case '183':
                        $('#start').datepicker('setDate', '-6m');
                        $('#stop').datepicker('setDate', date);
                        break;
                    case '365':
                        $('#start').datepicker('setDate', '-1y');
                        $('#stop').datepicker('setDate', date);
                        break;
                    default:
                        console.log('default');
                }
            })
        });
    </script>
</body>

</html>