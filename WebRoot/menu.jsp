<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>文件管理系统</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style1.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>

	<body>
		<div class="style1" position="absolute"
			style="margin: 0; padding: 0; height: 80">
			<div id="container" postion="absolute" style="padding: 0;">
				<div class="shell" position="absolute" style="margin: 0;">
					<!-- Main -->
					<div id="main">
						<div class="cl">
							&nbsp;
						</div>
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
										用户管理
									</h2>
								</div>
								<!-- End Box Head-->

								<div class="box-content">
									<table>

										<tr>
											<form action="addUser.action" method="post">
												<input type="submit" class=" add-button" value="添加用户"
													style="width: 120px; height: 26; text-align: center; border: 0" />
											</form>
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

		<!-- Content -->
		<div class="style" style="width: 99%">
			<!-- Content -->
			<div id="content">
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2 class="left">
							所有用户信息
						</h2>
						<div class="right">
							<form action="searchUser.action" method="post">

								<input type="text" name="searchName" size="40"
									class="field small-field" />

								<input type="submit" value="查找" method="searchUser"
									class="button" />
								<span>&nbsp</span>
								<select name="searchType">
									<option value="员工号">
										员工号
									</option>
									<option value="密码">
										密码
									</option>
									<option value="用户组别号">
										用户组别号
									</option>
									<option value="用户名">
										用户名
									</option>
									<option value="性别">
										性别
									</option>
									<option value="出生地">
										出生地
									</option>
									<option value="出生日期">
										出生日期
									</option>
									<option value="民族">
										民族
									</option>
									<option value="所属部门编号">
										所属部门编号
									</option>
									<option value="职位">
										职位
									</option>
									<option value="电子邮箱">
										电子邮箱
									</option>
								</select>
							</form>

						</div>
					</div>
					<!-- End Box Head -->
					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th align="center">
									员工号
								</th>
								<th align="center">
									用户组别号
								</th>
								<th align="center">
									用户名
								</th>
								<th align="center">
									所属部门编号
								</th>
								<th align="center">
									职位
								</th>
								<th align="center">
									查看
								</th>
								<th align="center">
									修改
								</th>
								<th align="center">
									删除
								</th>
							</tr>
							<s:iterator value="#request.allUser" id="allUser">
								<tr>
									<td align="center">
										<s:property value="#allUser.peopleId" />
									</td>
									<td align="center">
										<s:property value="#allUser.groupNo" />
									</td>
									<td align="center">
										<s:property value="#allUser.peopleName" />
									</td>
									<td align="center">
										<s:property value="#allUser.departmentNo" />
									</td>
									<td align="center">
										<s:property value="#allUser.position" />
									</td>
									<td align="center">
										<a
											href="check.action?people.peopleId=<s:property value="#allUser.peopleId"/>"
											class="ico dcl">查看</a>
									</td>
									<td align="center">
										<a
											href="edit.action?people1.peopleId=<s:property value="#allUser.peopleId"/>"
											class="ico dcl">修改</a>
									</td>
									<td align="center">
										<a
											href="deleteUser.action?people2.peopleId=<s:property value="#allUser.peopleId"/>"
											class="ico dcl">删除</a>
									</td>
								</tr>
							</s:iterator>
						</table>


						<!-- 前进后退首页 -->
						<div class="pagging">
							<div class="right">
								<s:set name="page" value="#request.page"></s:set>
								<s:if test="#page.hasFirst">
									<s:a href="userManage.action?pageNow=1">首页</s:a>
								</s:if>
								<s:if test="#page.hasPre">
									<a
										href="userManage.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
								</s:if>
								<s:if test="#page.hasNext">
									<a
										href="userManage.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
								</s:if>
								<s:if test="#page.hasLast">
									<a
										href="userManage.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
								</s:if>
							</div>
						</div>
						<!-- End Pagging -->
					</div>
					<!-- Table -->
				</div>
				<!-- End Box -->

				<!-- End Content -->
			</div>
		</div>
	</body>
</html>