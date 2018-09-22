<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/site/images/glabal.css"/>
    <script src="${pageContext.request.contextPath }/site/images/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath }/site/images/jquery.superslide.2.1.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        function setTab(name,num,n){
            for(i=1;i<=n;i++){
                var menu=document.getElementById(name+i);
                var con=document.getElementById(name+"_"+"con"+i);
                menu.className=i==num?"now":"";
                con.style.display=i==num?"block":"none";
            }
        }
    </script>
</head>
<body class="body">
<div class="main">
    <!--top-->
    <div class="top">
        <div class="search fr">
            <input type="text" id="rand" name="rand"  value="请输入检索关键词" onfocus="javascript:if(this.value=='请输入检索关键词')  {this.value='';this.style.color='#333'}" onblur="if(!value){value=defaultValue;this.style.color='#3283da'}" style="color:#3283da;">
              <a href="ss.html"><img src="${pageContext.request.contextPath }/site/images/search.png"/></a>
        </div>
        <img src="${pageContext.request.contextPath }/site/images/logo.png"/>
    </div>
    <!--nav_begin-->
    <div class="nav_box">
        <img class="nav_l" src="${pageContext.request.contextPath }/site/images/nav_left.png"/>
        <img class="nav_r" src="${pageContext.request.contextPath }/site/images/nav_right.png"/>
        <div class="nav">
            <ul class="menu" id="nav_all">
                <li class="home"><a href="index.html">首&nbsp;&nbsp;页</a></li>
                <li><a href="#">工作动态</a>
                    <ul class="#" style="width: 1000px;">
                        <a href="#">民航新闻</a>
                        <a href="${pageContext.request.contextPath }/3">行业动态</a>
                    </ul>
                </li>
                <li><a href="#">最新通知</a>
                   
                </li>
                <li><a href="#">机构简介</a>
                    <ul class="#" style="width: 736px;">
                        <a href="#">主要职责</a>
                        <a href="#">领导信息</a>
                        <a href="#">组织机构</a>
                    </ul>
                </li>
                <li><a href="#">办公应用</a>
                   
                </li>
                <li><a href="#">信息资源</a>
                  
                </li>
                <li><a href="#">信息统计</a>
                    
                </li>
                <li><a href="#">相关服务</a>
                  
                </li>
            </ul>
        </div>
    </div>
    <!--nav_over-->
    <div class="boxcenter gu-main">
        <!--当前位置-->
        <div class="loc"><a class="homepage" href="#"><img src="${pageContext.request.contextPath }/site/images/gu_iconhome.png"/>首页</a>&gt;<a href="gzdt.html">工作动态</a>&gt;<a class="on" href="gzdt.html">行业动态</a></div>
        <!--//当前位置-->
        <!-- 左侧菜单 -->
        <div class="sidebar-l fl">
            <h3>工作动态</h3>
            <ul>
                <li ><a href="#">民航新闻</a></li>
                <li class="active"><a href="#">行业动态</a></li>
            </ul>
        </div>
        <!-- //左侧菜单-->
        <div class="sidebar-r fr">
            <div class="gu-borBox">
                <div class="gu-list gu-list-group y_list2">
                    <div class="gu-cover-bor"></div>
                    <ul>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">国内50家航空公司实现残疾军人网络或电话购买优惠票</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">中国民航局局长冯正霖：满足人民美好生活需求 推动民航高质量发展</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">2018年春运民航运送旅客6541万人次</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">王志清会见土耳其驻华大使埃明·约南</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">冯正霖到中国航协考察调研</a> </li>
                    </ul>
                    <ul>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">国内50家航空公司实现残疾军人网络或电话购买优惠票</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">中国民航局局长冯正霖：满足人民美好生活需求 推动民航高质量发展</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">2018年春运民航运送旅客6541万人次</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">王志清会见土耳其驻华大使埃明·约南</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">冯正霖到中国航协考察调研</a> </li>
                    </ul>
                    <ul>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">国内50家航空公司实现残疾军人网络或电话购买优惠票</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">中国民航局局长冯正霖：满足人民美好生活需求 推动民航高质量发展</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">2018年春运民航运送旅客6541万人次</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">王志清会见土耳其驻华大使埃明·约南</a> </li>
                        <li><span>2018-03-28</span><a href="${pageContext.request.contextPath }/3/20180918_189414">冯正霖到中国航协考察调研</a> </li>
                    </ul>
                </div>
            </div>
            <div class="pages">
                <span><a>首页</a></span>
                <span><a>上一页</a></span>
                <a class="on" href="">1</a>
                <a href="">2</a>
                <a href="">3</a>
                <a href="">4</a>
                <a href="">5</a>
                <span><a>下一页</a></span>
                <span><a>尾页</a></span>
            </div>           
        </div>

    </div>

</div>
<!--foot-->
<div class="foot">
    <div class="boxcenter foot_in">
        <p><img src="${pageContext.request.contextPath }/site/images/y_foot_logo.png"/></p>
        <h2>版权所有：中国民用航空局</h2>
        <h3>地址：北京市东城区东四西大街155号（100710）</h3>
        <h4><a href="#">网站地图</a></h4>
    </div>
</div>
</body>
</html>
