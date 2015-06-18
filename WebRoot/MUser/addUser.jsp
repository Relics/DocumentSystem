<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<body>
		<s:form action="saveAdd.action" method="post" enctype="multipart/form-data">
			员工号：<input type="text" name="people.peopleId"><br>
			密码：<input type="password" name="people.password"><br>
			用户组别号：<input type="text" name="people.groupNo"><br>
			用户名：<input type="text" name="people.peopleName"><br>
			照片：<input type="file" name="upload" id="fileUpload"><br>
			性别：<input type="text" name="people.male"><br>
			出生地：<input type="text" name="people.bornPlace"><br>
			出生日期：<input type="text" name="people.bornYear"><br>
			民族：<input type="text" name="people.nation"><br>
			所属部门编号：<input type="text" name="people.departmentNo"><br>
			职位：<input type="text" name="people.position"><br>
			电子邮箱：	<input type="text" name="people.email">
			<s:submit value="确认添加"/>
		</s:form>
		<s:fielderror />
	</body>
</html>