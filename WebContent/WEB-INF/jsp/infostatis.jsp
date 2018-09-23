<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>信息统计</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/site/css/jquery-ui.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/site/css/glabal.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/theme/macarons.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/echarts-gl.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/ecStat.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/dataTool.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/china.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/bmap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/site/js/simplex.js"></script>
</head>
<body>
	<div class="sidebar-r fr">
		<div class="gu-borBox">
			<div id="main" style="width: 920px; height: 400px;"></div>
			<div class="gu-list gu-list-group y_list2">
				<b>访问量前五：
				<h3>选择日期：
				<select id="select" style="font-family:'微软雅黑'" name="select" onchange="sub()">								
								<option value="7">最近7天</option>
								<option value="30">最近30天</option>
								<option value="183">最近半年</option>
								<option value="365">一年内</option>
								<option value="all">全部</option>
							</select>							
							&nbsp;&nbsp; &nbsp;
					</h3>
					<form method="post">
						<h3>
							按日期查找：&nbsp;&nbsp; 							
							<input id="start" class="Wdate"	placeholder="请选择日期" type="text" name="startTime"
								   onclick="WdatePicker()" />&nbsp;至&nbsp;
                            <input type="text" id="stop" class="dp">
							<!-- <input id="start" class="Wdate" placeholder="请选择日期" type="text" name="startTime"
								   onclick="WdatePicker()" />&nbsp;至&nbsp;
							<input id="stop" class="Wdate" placeholder="请选择日期" type="text" name="endTime"
								onclick="WdatePicker()" /> -->
						    <input type="button" value="搜索" class="button" onclick="sub()">
						</h3>
					</form>
				</b>
				<div class="gu-cover-bor"></div>
				<div id="tab">
				</div>
			</div>			
		</div>
		<a href="${pageContext.request.contextPath }/3" style="float: ">进入测试页面</a>
	</div>
</body>
<script type="text/javascript">
function setTab(name, num, n) {
	for (i = 1; i <= n; i++) {
		var menu = document.getElementById(name + i);
		var con = document.getElementById(name + "_" + "con" + i);
		menu.className = i == num ? "now" : "";
		con.style.display = i == num ? "block" : "none";
	}
}
// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'),
		"macarons");
var app = {};
option = null;
var FwCou = [];
var Fwtime=[];
var FbCou = [];				
option = {
	title : {
		text : '数据统计',
	},
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		data : [ '访问量', '发稿量' ]
	},
	toolbox : {
		show : true,
		feature : {
			dataZoom : {
				yAxisIndex : 'none'
			},
			dataView : {
				readOnly : false
			},
			magicType : {
				type : [ 'line', 'bar' ]
			},
			restore : {},
			saveAsImage : {}
		}
	},
	xAxis : {
		name:'   日期',
		type : 'category',
		boundaryGap : false,
		data : []
	},
	yAxis : {
		name:'   数量',
		type : 'value',
		axisLabel : {
			formatter : '{value} '
		}
	},
	series : [ {
		name : '访问量',
		type : 'line',
		data : [],
		markPoint : {
			data : [ {
				type : 'max',
				name : '最大值'
			}, {
				type : 'min',
				name : '最小值'
			} ]
		},
		markLine : {
			data : [ {
				type : 'average',
				name : '平均值'
			} ]
		}
	}, {
		name : '发稿量',
		type : 'line',
		data : [],
		markPoint : {
			data : [ {
				type : 'max',
				name : '最大值'
			}, {
				type : 'min',
				name : '最小值'
			} ]
		},
		markLine : {
			data : [ {
				type : 'average',
				name : '平均值'
			} ]
		}
	} ]
};
/* echarts end  */
$.ajax({
		url : '${pageContext.request.contextPath }/doStatis.html',
		date : "",
		type : 'get',
		dataType : "json",
		async : true, //同步
		contentType : 'application/json;charset=utf-8',
		success : function(data) {
			if (data != null && data.length > 0) {
				for (var i = 0; i < data.length; i++) {
					FwCou.push(data[i].FWCount);
					Fwtime.push(data[i].daystr);
					FbCou.push(data[i].FBCount);
				}
			}
		}
	})
if (option && typeof option === "object") {
	myChart.setOption(option, true);
	myChart.setOption({ //载入数据
		xAxis : {
			data : Fwtime
		//填入X轴数据
		},series : [ {
			data : FwCou
		}, {
			data : FbCou
		} ]
	});
}

//搜索
function sub(){		
	//获取被选中的option标签
    var start = $("#start").val();
    var stop = $("#stop").val();
	console.info("start:"+start);
	$.ajax({
		url: "${pageContext.request.contextPath }/doStartEndInfo.html",
	    type: "GET",
		dataType: "text",
		//把获取到的value值传给服务器
		data: {"startTime": start,"endTime":stop},
		success: function(data) {
			$("#tab").html("");
			if (data!=null && data.length>0){
				var json = eval('(' + data + ')');
				console.info($("#tab"));
				for(var i=0;i<json.length;i++){
					$("#tab").append("<li><div style='float:left'>"+json[i].doctitle+"("+json[i].docpubtime+")</div><div style='float:right'>"+json[i].docclickcount+"</div></li>");
					console.info(json[i]);
				}
			}
		},
		error:function(){
			console.info("error");
		}
	});
}
//日期下拉事件
$(function () {
    $("#start,#stop").datepicker({
        showButtonPanel: true,
        dateFormat: "yy-mm-dd",
        defaultDate: +0,
    });
    var date = $.datepicker.formatDate("yy-mm-dd", new Date());
    $('#start').datepicker('setDate', '-7');
    $('#stop').datepicker('setDate', date);
    sub();
    $('#select').change(function (e) {
        var val = $(this).val();
        switch (val) {                    
            case '7':
                $('#start').datepicker('setDate', '-7');
                $('#stop').datepicker('setDate', date);
                sub();
                break;
            case '30':
                $('#start').datepicker('setDate', "-30");
                $('#stop').datepicker('setDate', date);
                sub();
                break;
            case '183':
                $('#start').datepicker('setDate', '-6m');
                $('#stop').datepicker('setDate', date);
                sub();
                break;
            case '365':
                $('#start').datepicker('setDate', '-1y');
                $('#stop').datepicker('setDate', date);
                sub();
                break;
            case 'all':
                $('#start').datepicker('setDate', '');
                $('#stop').datepicker('setDate', '');
                sub();
                break;
            default:
                console.log('default');
        }
    })
});

$(function () {
	$("#stop").datepicker();
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});
jQuery(function ($) {
	$.datepicker.regional['zh-CN'] = {
	closeText: '关闭',
	prevText: '<上月',
	nextText: '下月>',
	currentText: '今天',
	monthNames: ['一月', '二月', '三月', '四月', '五月', '六月',
	'七月', '八月', '九月', '十月', '十一月', '十二月'],
	monthNamesShort: ['一', '二', '三', '四', '五', '六',
	'七', '八', '九', '十', '十一', '十二'],
	dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
	dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
	dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
	weekHeader: '周',
	dateFormat: 'yy-mm-dd',
	firstDay: 1,
	isRTL: false,
	showMonthAfterYear: true,
	yearSuffix: '年'
	};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});
    </script>
</html>