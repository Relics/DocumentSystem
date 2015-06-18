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
		<s:form action="savePersonalEdit.action" method="post"
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
								<s:iterator value="#request.allInfo1" id="allInfo1">
									<p>
										<label>
											姓名
											<span>（不可修改，请联系管理员修改）</span>
										</label>
										<input type="text" name="people1.peopleName"
											value="<s:property value="#allInfo1.peopleName"/>"
											readonly="readonly" class="field size1" />
										<br />
										<label>
											性别
											<span>（不可修改，请联系管理员修改）</span>
										</label>
										<input type="text" name="people1.male"
											value="<s:property value="#allInfo1.male"/>" readOnly
											class="field size1" />
										<br />
										<label>
											工号
											<span>（不可修改，请联系管理员修改）</span>
										</label>
										<input type="text" name="people1.peopleId"
											value="<s:property value="#allInfo1.peopleId"/>"
											readonly="readonly" class="field size1" />
										<br />
										<label>
											密码
										</label>
										<input type="text" name="people1.password"
											value="<s:property value="#allInfo1.password"/>"
											class="field size1" />
										<br />
										<label>
											籍贯
										</label>
										<input type="text" name="people1.bornPlace"
											value="<s:property value="#allInfo1.bornPlace"/>"
											class="field size1" />
										<br />
										<label>
											用户组别号
											<span>（不可修改，请联系管理员修改）</span>
										</label>
										<input type="text" name="people1.groupNo"
											value="<s:property value="#allInfo1.groupNo"/>"
											readonly="readonly" class="field size1" />
										<br />
										<label>
											民族
										</label>
										<input type="text" name="people1.nation"
											value="<s:property value="#allInfo1.nation"/>"
											class="field size1" />
										<br />
										<label>
											出生年份
										</label>
										<input type="Date" name="people1.bornYear" class="field size1" />
										<br />
										<label>
											所属部门编号
											<span>（不可修改，请联系管理员修改）</span>
										</label>
										<input type="text" name="people1.departmentNo"
											value="<s:property value="#allInfo1.departmentNo"/>"
											readonly="readonly" class="field size1" />
										<br />
										<label>
											职位
										</label>
										<input type="text" name="people1.position"
											value="<s:property value="#allInfo1.position"/>"
											class="field size1" />
										<br />
										<label>
											Email地址
										</label>
										<input type="text" name="people1.email"
											value="<s:property value="#allInfo1.email"/>"
											class="field size1" />
										<br />
										<label>
											照片
										</label>
										<input type="file" name="upload" id="fileUpload">
										<input type="hidden" name="people1.photo" 
										value="<s:property value="#allInfo1.photo"/>"/>
										</p></s:iterator>
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