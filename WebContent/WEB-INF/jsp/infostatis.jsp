<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/site/css/glabal.css" />
<%-- <script src="${pageContext.request.contextPath }/site/js/jquery.js"
	type="text/javascript" charset="utf-8"></script> --%>
<%-- <script
	src="${pageContext.request.contextPath }/site/js/jquery.superslide.2.1.1.js"
	type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath }/site/js/echarts.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/echarts.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/echarts-gl.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/ecStat.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/dataTool.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/china.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/site/js/world.js"></script>
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
				var dom = document.getElementById("main");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
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
						data : [ 11, 11, 15, 13, 12, 13, 10 ],
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
						data : [ 1, 5, 2, 5, 3, 2, 0 ],
						markPoint : {
							data : [ {
								name : '周最低',
								value : -2,
								xAxis : 1,
								yAxis : -1.5
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							}, [ {
								symbol : 'none',
								x : '90%',
								yAxis : 'max'
							}, {
								symbol : 'circle',
								label : {
									normal : {
										position : 'start',
										formatter : '最大值'
									}
								},
								type : 'max',
								name : '最高点'
							} ] ]
						}
					} ]
				};
				;
				if (option && typeof option === "object") {
					myChart.setOption(option, true);
				}
			</script>
			<script type="text/javascript">
				var today = new Date(); //获取今天日期
				today.setDate(today.getDate() - 7);
				var dateArray = []; 
				var dateTemp; 
				var flag = 1; 
				for (var i = 0; i < 7; i++) {					
				    dateTemp =today.getFullYear()+"-"+ (today.getMonth()+1)+"-"+today.getDate();				
				    dateArray.push(dateTemp);
				    today.setDate(today.getDate() + flag);
				} 
				$("#today").val(dateArray[0]);
				$("#weeks").val(dateTemp);

			</script>
			<div class="gu-list gu-list-group y_list2">
				<b>访问量前五：
					<form action="${pageContext.request.contextPath }/doStartEndInfo.html" method="post">
						<h3>
							 按日期查找：&nbsp;&nbsp;
								<select style="font-family:"微软雅黑"">
								<option value="weeks" style="font-family:"微软雅黑"">全部</option>
								<option value="all">最近7天</option>
								<option value="month">最近30天</option>
								<option value="opel">最近半年</option>
								<option value="years">一年内</option>								
							</select>&nbsp;&nbsp;
							 &nbsp;<input id="today" class="Wdate" placeholder="请选择日期"
								type="text" name="startTime" onclick="WdatePicker()" />&nbsp;至&nbsp;<input
								id="weeks" class="Wdate" placeholder="请选择日期" type="text"
								name="endTime" onclick="WdatePicker()" /> <input type="submit"
								value="搜索" class="button">								
						</h3>
					</form>
				</b>


				<div class="gu-cover-bor"></div>				
				<c:forEach items="${list}" var="lists" varStatus="vs">
					<tbody>
						<tr>							
							<li><span><td>${lists.DOCCLICKCOUNT}</td></span><a href="#"><td>${lists.DOCTITLE}</td></a>							
					</tbody>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>