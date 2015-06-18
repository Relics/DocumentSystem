<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="all" />
	</head>
	<body class="style">
		<div id="container" position="absolute"
			style="width: 100%; margin: 0; padding: 0; float: left;">
			<div class="shell">
				<!-- Main -->
				<div id="main">
					<!-- Box -->
					<div class="box">
						<!-- Box Head -->
						<div class="box-head">
							<h2>
								添加用户
							</h2>
						</div>
						<!-- Form -->

						<s:form action="saveAdd.action" method="post"
							enctype="multipart/form-data">
							<div class="form">

								<p>
									<label>
										姓名
									</label>
									<input type="text" name="people.peopleName" class="field size1" />
									<br />
									<label>
										性别
									</label>
									<select name="people.male" class="field size1" >
									   <option value ="男">男</option>
									   <option value ="女">女</option>
									</select>
									<br />
									<label>
										工号
									</label>
									<input type="text" name="people.peopleId" class="field size1" />
									<br />
									<label>
										密码
									</label>
									<input type="text" name="people.password" class="field size1" />
									<br />
									<label>
										籍贯
									</label>
									<input type="text" name="people.bornPlace" class="field size1" />
									<br />
									<label>
										用户组别
									</label>
									<select name="people.groupNo" class="field size1" >
									   <option value ="0">管理员</option>
									   <option value ="2">领导</option>
									   <option value ="1">普通用户</option>
									</select>
									<br />
									<label>
										民族
									</label>
									<input type="text" name="people.nation" class="field size1" />
									<br />
									<label>
										出生年份
									</label>
									<input type="Date" name="people.bornYear" class="field size1" />
									<br />
									<label>
										所属部门
									</label>
									<select name="people.departmentNo" class="field size1" >
									   <option value ="0">后台管理部门</option>
									   <option value ="1">财务部门</option>
									   <option value ="2">教务部门</option>
									   <option value ="3">党务部门</option>
									   <option value ="4">资产部门</option>
									   <option value ="5">工会部门</option>
									   <option value ="6">学生部门</option>
									   <option value ="7">教职工部门</option>
									   <option value ="8">领导</option>
									</select>
									<br />
									<label>
										职位
									</label>
									<input type="text" name="people.position" class="field size1" />
									<br />
									<label>
										Email地址
									</label>
									<input type="text" name="people.email" class="field size1" />
									<br />
									<label>
										照片
									</label>
									<input type="file" name="upload" id="fileUpload">
								<p>
									<input type="hidden" name="people.photo"
										value="<s:property value="#allInfo.photo"/>" />
							</div>
							<!-- End Form -->
							<!-- Form Buttons -->
							<div class="buttons">
								<input type="submit" class="button2" value="确认添加" />
							</div>
							<!-- End Form Buttons -->
						</s:form>
					</div>
					<!-- End Box -->
				</div>
				<!-- End Content -->
			</div>
			<!-- Main -->
		</div>
	</body>
</html>
