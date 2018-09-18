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
<!-- <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css"> 
<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script> 
<script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/site/css/glabal.css" />
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/jquery.js"></script> --%>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/jquery.superslide.2.1.1.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/echarts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/theme/macarons.js"></script>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/echarts-gl.min.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/ecStat.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/dataTool.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/china.js"></script>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/world.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/bmap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/simplex.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/jquery-1.7.2.min.js">
	<script type="text/javascript">
	function setTab(name, num, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById(name + "_" + "con" + i);
			menu.className = i == num ? "now" : "";
			con.style.display = i == num ? "block" : "none";
		}
	}
</script>
</head>
<body>
	<div class="sidebar-r fr">
		<div class="gu-borBox">
			<div id="main" style="width: 920px; height: 400px;"></div>
			<script type="text/javascript">
				// 基于准备好的dom，初始化echarts实例
				var myChart = echarts.init(document.getElementById('main'),
						"macarons");
				var app = {};
				option = null;
				var FwCou = [];
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
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					},
					yAxis : {
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
							url : '${pageContext.request.contextPath }/doInfoStatis.html',
							date : "",
							type : 'get',
							dataType : "json",
							async : false, //同步
							contentType : 'application/json;charset=utf-8',
							success : function(data) {
								if (data != null && data.length > 0) {
									for (var i = 0; i < data.length; i++) {
										FwCou.push(data[i].FWCount);
									}
								}
							}
						})
				$.ajax({
							url : '${pageContext.request.contextPath }/doPubCount.html',
							date : "",
							type : 'get',
							dataType : "json",
							async : false, //同步
							contentType : 'application/json;charset=utf-8',
							success : function(data) {
								if (data != null && data.length > 0) {
									for (var i = 0; i < data.length; i++) {
										FbCou.push(data[i].FBCount);
									}
								}
							}
						})
				if (option && typeof option === "object") {
					myChart.setOption(option, true);
					myChart.setOption({ //载入数据
						series : [ {
							data : FwCou
						}, {
							data : FbCou
						} ]
					});
				}
			</script>
			<script type="text/javascript">
			$(function () {
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
			<div class="gu-list gu-list-group y_list2">
				<b>访问量前五：
					<form
						action="${pageContext.request.contextPath }/doStartEndInfo.html"
						method="post">
						<h3>
							按日期查找：&nbsp;&nbsp; <select id="select" style="font-family:"微软雅黑"">
								<option value="all" style="font-family:"微软雅黑"">全部</option>
								<option value="7">最近7天</option>
								<option value="30">最近30天</option>
								<option value="183">最近半年</option>
								<option value="365">一年内</option>
							</select>&nbsp;&nbsp; &nbsp;<input id="start" class="Wdate"
								placeholder="请选择日期" type="text" name="startTime"
								onclick="WdatePicker()" />&nbsp;至&nbsp;<input id="stop"
								class="Wdate" placeholder="请选择日期" type="text" name="endTime"
								onclick="WdatePicker()" /> <input type="submit" value="搜索"
								class="button">
						</h3>
					</form>
				</b>


				<div class="gu-cover-bor"></div>
				<c:forEach items="${list}" var="lists" varStatus="vs">
					<tbody>
						<tr>
							<li><span><td>${lists.DOCCLICKCOUNT}</td></span> <a href="#"><td>${lists.DOCTITLE}(<fmt:formatDate
											value="${lists.DOCPUBTIME }" pattern="yyyy-MM-dd" />)
								</td></a>
					</tbody>
				</c:forEach>				
			</div>			
		</div>
		<a href="${pageContext.request.contextPath }/3" style="float: ">进入测试页面</a>
	</div>
</body>
</html>