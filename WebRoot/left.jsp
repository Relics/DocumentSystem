<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>文件管理系统</title>
		<!--左侧导航栏的style-->
		<link href="css/topanv.v1.0.css" rel="stylesheet" type="text/css" />
		<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
		<script src="js/topanv.js"></script>
		<style type="text/css">
body {
	margin: 0;
	padding: 0;
	overflow-x: hidden;
}

html,body {
	height: 100%;
}

img {
	border: none;
}

* {
	font-family: '微软雅黑';
	font-size: 12px;
	color: #626262;
}

dl,dt,dd {
	display: block;
	margin: 0;
}

a {
	text-decoration: none;
}

#bg {
	background-image: url(images/content/dotted.png);
}

.container {
	width: 100%;
	height: 100%;
	margin: auto;
}

/*left*/
.leftsidebar_box {
	width: 160px;
	height: auto !important;
	overflow: visible !important;
	position: fixed;
	height: 100% !important;
	background-color: #3992d0;
}

.line {
	height: 2px;
	width: 100%;
	background-image: url(images/left/line_bg.png);
	background-repeat: repeat-x;
}

.leftsidebar_box dt {
	padding-left: 40px;
	padding-right: 10px;
	background-repeat: no-repeat;
	background-position: 10px center;
	color: #f5f5f5;
	font-size: 14px;
	position: relative;
	line-height: 48px;
	cursor: pointer;
}

.leftsidebar_box dd {
	background-color: #317eb4;
	padding-left: 40px;
}

.leftsidebar_box dd a {
	color: #f5f5f5;
	line-height: 20px;
}

.leftsidebar_box dl dt a {
	color: #ffffff;
}

.leftsidebar_box dt img {
	position: absolute;
	right: 10px;
	top: 20px;
}

.system_log dt {
	background-image: url(images/left/system.png)
}

.custom dt {
	background-image: url(images/left/custom.png)
}

.channel dt {
	background-image: url(images/left/channel.png)
}

.app dt {
	background-image: url(images/left/app.png)
}

.cloud dt {
	background-image: url(images/left/cloud.png)
}

.syetem_management dt {
	background-image: url(images/left/syetem_management.png)
}

.source dt {
	background-image: url(images/left/source.png)
}

.statistics dt {
	background-image: url(images/left/statistics.png)
}

.leftsidebar_box dl dd:last-child {
	padding-bottom: 10px;
}
</style>
	</head>
	<body id="bg">

		<!--左侧导航栏-->
		<div class="container">
			<div class="leftsidebar_box">
				<div class="line"></div>
				<dl class="system_log">
					<dt onClick="changeImage()">
						<a href="allFile.action" target="right">全部文件</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="system_log">
					<dt onClick="changeImage()">
						<a href="myFile.action" target="right">我的文件</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>

				<hr size="1" width="100%" color="white" noshade="noshade" />
				<dl class="custom">
					<dt onClick="changeImage()">
						<a href="leader.action" target="right">领导部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="system_log">
					<dt onClick="changeImage()">
						<a href="jiaowu.action" target="right">教务管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="channel">
					<dt>
						<a href="caiwu.action" target="right">财务管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="app">
					<dt onClick="changeImage()">
						<a href="dangwu.action" target="right">党务管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="cloud">
					<dt>
						<a href="zichan.action" target="right">资产管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="syetem_management">
					<dt>
						<a href="gonghui.action" target="right">工会管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="source">
					<dt>
						<a href="xuesheng.action" target="right">学生管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				<dl class="statistics">
					<dt>
						<a href="jiaozhigong.action" target="right">教职工管理部门</a>
						<img src="images/left/select_xl01.png">
					</dt>
				</dl>
				
			</div>
		</div>

		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript">
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
		$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
		$(function(){
			$(".leftsidebar_box dd").hide();
			$(".leftsidebar_box dt").click(function(){
				$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
				$(this).css({"background-color": "#317eb4"});
				$(this).parent().find('dd').removeClass("menu_chioce");
				$(".leftsidebar_box dt img").attr("src","images/left/select_xl01.png");
				$(this).parent().find('img').attr("src","images/left/select_xl.png");
				$(".menu_chioce").slideUp(); 
				$(this).parent().find('dd').slideToggle();
				$(this).parent().find('dd').addClass("menu_chioce");
			});
		})
		</script>
	</body>
</html>
