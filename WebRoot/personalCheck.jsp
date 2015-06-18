<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.js"></script>

		<title>文件管理系统</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style1.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>
	<body>
		<div class="style1" position="absolute"
			style="margin: 0; padding: 0; height: 78px; width: 99%">
			<div id="container" postion="absolute" style="padding: 0;">
				<div class="shell" position="absolute" style="margin: 0;">
					<!-- Main -->
					<div id="main">
						<!-- Content2 -->
						<div id="content2" position="absolute"
							style="padding: 0; margin: 0;">

							<!-- Box -->
							<div class="box" position="absolute"
								style="padding: 0; margin: 0;">

								<!-- Box Head -->
								<div class="box-head" position="absolute"
									style="padding: 0 0 0 15; margin: 0;">
									<h2>
										信息管理
									</h2>
								</div>
								<!-- End Box Head-->
								<div class="box-content">
									<table>
										<tr>
											<form action="personalEdit.action" method="post">
												<input type="submit" class="add-button" value="修改信息"
													style="width: 120px; height: 26; text-align: center; border: 0" />
											</form>
										</tr>
									</table>
								</div>
								<div class="box-content">
									<table>
										<tr>

										</tr>
									</table>
								</div>
							</div>
							<!-- End Box -->
						</div>
						<!-- End Sidebar -->
					</div>
					<!-- Main -->
				</div>
			</div>
		</div>

		<div class="style">
			<!-- Form -->
			<div id="container" position="absolute"
				style="width: 99%; margin: 0; padding: 0; float: left;">
				<div class="shell">
					<!-- Main -->
					<div id="main">
						<!-- Box -->
						<div class="box">
							<!-- Box Head -->
							<div class="box-head">
								<h2>
									个人信息
								</h2>
							</div>

							<s:iterator value="#request.allInfo" id="allInfo">
								<p>
								<div class="form">
									<label>
										姓名
									</label>
									<input type="text"
										value="<s:property value="#allInfo.peopleName"/>"
										class="field size1" readonly="readonly" />
									<br />
									<label>
										性别
									</label>
									<input type="text" value="<s:property value="#allInfo.male"/>"
										readonly="readonly" class="field size1" />
									<br />
									<label>
										工号
									</label>
									<input type="text"
										value="<s:property value="#allInfo.peopleId"/>"
										readonly="readonly" class="field size1" />
									<br />
									<label>
										密码
									</label>
									<input type="text"
										value="<s:property value="#allInfo.password"/>"
										class="field size1" readonly="readonly" />
									<br />
									<label>
										籍贯
									</label>
									<input type="text"
										value="<s:property value="#allInfo.bornPlace"/>"
										class="field size1" readonly="readonly" />
									<br />
									<label>
										所在组别
									</label>
									<s:if test="#allInfo.groupNo==0">
										<input type="text" value="管理员" class="field size1"
											readonly="readonly" />
										<br />
									</s:if>
									<s:elseif test="#allInfo.groupNo==1">
										<input type="text" value="普通用户" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.groupNo==2">
										<input type="text" value="领导" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>

									<label>
										民族
									</label>
									<input type="text"
										value="<s:property value="#allInfo.nation"/>"
										class="field size1" readonly="readonly" />
									<br />
									<label>
										出生年份
									</label>
									<input type="text"
										value="<s:property value="#allInfo.bornYear"/>"
										class="field size1" readonly="readonly" />
									<br />
									<label>
										所属部门
									</label>
									<s:if test="#allInfo.departmentNo==0">
										<input type="text" value="后台管理" class="field size1"
											readonly="readonly" />
										<br />
									</s:if>
									<s:elseif test="#allInfo.departmentNo==1">
										<input type="text" value="财务部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==2">
										<input type="text" value="教务部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==3">
										<input type="text" value="党务部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==4">
										<input type="text" value="资产部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==5">
										<input type="text" value="工会部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==6">
										<input type="text" value="学生部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==7">
										<input type="text" value="教职工部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<s:elseif test="#allInfo.departmentNo==8">
										<input type="text" value="领导部门" class="field size1"
											readonly="readonly" />
										<br />
									</s:elseif>
									<label>
										职位
									</label>
									<input type="text"
										value="<s:property value="#allInfo.position"/>"
										class="field size1" readonly="readonly" />
									<br />
									<label>
										Email地址
									</label>
									<input type="text" value="<s:property value="#allInfo.email"/>"
										class="field size1" readonly="readonly" />
									<br />

									<p></p>
									<label>
										照片
									</label>
									<img src="<s:property value="#allInfo.photo"/>"
										readonly="readonly" style="max-width: 500px;" />
							</s:iterator>

							<!-- End Form Buttons -->
						</div>
						<!-- End Box -->
					</div>
					<!-- End Content -->
				</div>
			</div>
		</div>
	</body>