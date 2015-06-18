<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>文件管理系统</title>
	</head>
	<frameset rows="14%,*" border="0">
		<frame src="upTitle.jsp">

		<frameset cols="12%,*" border="1">
			<frame src="left.jsp">
			<frameset rows="*,8%">
				<frame src="right.jsp" name="right">

				<frame src="downTitle.jsp">
			</frameset>
		</frameset>
	</frameset>
</html>