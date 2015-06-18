<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<link href="css/topanv.v1.0.css" rel="stylesheet" type="text/css" />
		<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
		<script src="js/topanv.js"></script>
		<title>文件管理系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<!--上方的图片显示栏-->
		<div style="height: 90px">
			<!--Header 2 -->
			<div id="top-navigation">
				欢迎&nbsp;&nbsp;
				<a href="personalCheck.action" target="right"><hehe><s:property value="#session.user.peopleName" /></hehe></a>
				<span>|</span>
				<s:if test="#session.user.groupNo==0">
					<a href="userManage.action" target="right">用户管理</a>
					<span>|</span>
				</s:if>
				<a href="disFeedback.action" target="right">投诉建议</a>
				<span>|</span>
				<a href="logOut.action" target="main">退出系统</a>
			</div>

			<!-- Header 1-->
			<div id="header">
				<div class="shell">
					<!-- Logo + Top Nav -->
					<div id="top">
						<img src="images/lc/slogon.jpg"
							style="FILTER: alpha(opacity =   0)" height="89" width="650">
					</div>
					<!-- End Logo + Top Nav -->
				</div>
				<!-- End Shell Nav -->
			</div>
			<!-- End Header -->
		</div>
	</body>
</html>
