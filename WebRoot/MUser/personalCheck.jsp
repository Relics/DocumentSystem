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
	</head>
	<body>
		<s:form action="personalEdit.action" method="post">
			<s:submit value="修改信息" align="left"/>
		</s:form>	
		<table width="400" border="1">
   			<caption>用户详细信息</caption>
   			<s:iterator value="#request.allInfo" id="allInfo">
				<tr><td>员工号:</td>
					<td align="center"><s:property value="#allInfo.peopleId"/></tr>
				<tr><td>密码：</td>
					<td align="center"><s:property value="#allInfo.password"/></tr>
				<tr><td>用户组别号：</td>
					<td align="center"><s:property value="#allInfo.groupNo"/></tr>
				<tr><td>用户名：</td>
					<td align="center"><s:property value="#allInfo.peopleName"/></tr>
				<tr><td>照片：</td>
					<td align="center"><img src="<s:property value="#allInfo.photo"/>"/></tr>
				<tr><td>性别：</td>
					<td align="center"><s:property value="#allInfo.male"/></tr>
				<tr><td>出生地：</td>
					<td align="center"><s:property value="#allInfo.bornPlace"/></tr>
				<tr><td>出生日期：</td>
					<td align="center"><s:property value="#allInfo.bornYear"/></tr>
				<tr><td>民族：</td>
					<td align="center"><s:property value="#allInfo.nation"/></tr>
				<tr><td>所属部门编号：</td>
					<td align="center"><s:property value="#allInfo.departmentNo"/></tr>   			
				<tr><td>职位：</td>
					<td align="center"><s:property value="#allInfo.departmentNo"/></tr>  
				<tr><td>电子邮箱：</td>
					<td align="center"><s:property value="#allInfo.email"/></tr>   			   
   			</s:iterator>
   		</table>
	</body>
</html>