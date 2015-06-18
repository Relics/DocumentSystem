<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style.css"
			type="text/css" media="all" />
	</head>
	<body class="style">
		<s:form action="saveEdit.action" method="post"
			enctype="multipart/form-data">
			<div id="container"  position="absolute" style="width:100%; margin:0;padding:0; float:left;">
				<div class="shell">
					<!-- Main -->
					<div id="main">
						<!-- Box -->
						<div class="box">
							<!-- Box Head -->

							<div class="box-head">
								<h2>
									个人信息修改
								</h2>
							</div>
							<!-- End Box Head -->
							<form action="" method="post">

								<!-- Form -->
								<div class="form">
								<s:iterator value="#request.allInfo" id="allInfo">
									<p>
										<label>
											姓名
										</label>
										<input type="text" name="people1.peopleName"
											value="<s:property value="#allInfo.peopleName"/>"
											class="field size1" />
										<br />
										<label>
											性别
										</label>
										<select name="people1.male" class="field size1" >
										   <option value ="男">男</option>
										   <option value ="女">女</option>
										</select>
										<br />
										<label>
											工号
										</label>
										<input type="text" name="people1.peopleId"
											value="<s:property value="#allInfo.peopleId"/>"
											 class="field size1" />
										<br />
										<label>
											密码
										</label>
										<input type="text" name="people1.password"
											value="<s:property value="#allInfo.password"/>"
											class="field size1" />
										<br />
										<label>
											籍贯
										</label>
										<input type="text" name="people1.bornPlace"
											value="<s:property value="#allInfo.bornPlace"/>"
											class="field size1" />
										<br />
										<label>
											用户组别号
										</label>
										<select name="people1.groupNo" class="field size1" >
										   <option value ="0">管理员</option>
										   <option value ="2">领导</option>
										   <option value ="1">普通用户</option>
										</select>
										<br />
										<label>
											民族
										</label>
										<input type="text" name="people1.nation"
											value="<s:property value="#allInfo.nation"/>"
											class="field size1" />
										<br />
										<label>
											出生年份
										</label>
										<input type="Date" name="people1.bornYear" class="field size1" />
										<br />
										<label>
											所属部门
										</label>
										<select name="people1.departmentNo" class="field size1" >
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
										<input type="text" name="people1.position"
											value="<s:property value="#allInfo.position"/>"
											class="field size1" />
										<br />
										<label>
											Email地址
										</label>
										<input type="text" name="people1.email"
											value="<s:property value="#allInfo.email"/>"
											class="field size1" />
										<br />
										<label>
											照片
										</label>
										<input type="file" name="upload" id="fileUpload">
										<p>
										<input type="hidden" name="people1.photo"
											value="<s:property value="#allInfo.photo"/>" />
								</s:iterator>
								</div>
								<!-- End Form -->
								<!-- Form Buttons -->
								<div class="buttons">
									<input type="submit" class="button2" value="提交修改" />
								</div>
								<!-- End Form Buttons -->
							</form>
						</div>
						<!-- End Box -->

					</div>
					<!-- End Content -->
				</div>
				<!-- Main -->
			</div>
		</s:form>
	</body>
</html>