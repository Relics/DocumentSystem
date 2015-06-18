<%@page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
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
										文件管理
									</h2>
								</div>
								<!-- End Box Head-->

								<div class="box-content">
									<table>
										<tr>
											<form
												action="newFold.action?newFolder=<s:property value="#request.caiwuDept"/>"
												method="post">
												<input type="submit" method="newFold" class="add-button"
													value="新建文件夹"
													style="width: 120px; height: 26; text-align: center; border: 0" />

											</form>

										</tr>
										<tr>
										<label class="add-button2"> </label>
										</tr>
										<tr>

											<form action="upload1.action" method="post">
												<input type="submit" method="upload1" class="add-button"
													value="上传文件"
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
							党务管理部门文件
						</h2>
						<div class="right">
							<form action="search.action" method="post">
								<input type="text" name="searchName" size="40"
									class="field small-field" />
								<input type="submit" value="查找" method="search" class="button" />
							</form>
						</div>
					</div>
					<!-- End Box Head -->

					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">

							<tr>

								<th align="center">
									文件名
								</th>
								<th align="center">
									修改日期
								</th>
								<th align="center">
									拥有者id
								</th>
								<th align="center">
									文件路径
								</th>
								<th align="center">
									类型
								</th>
								<th align="center">
									大小
								</th>
								<th align="center">
									下载
								</th>
								<th align="center">
									查看
								</th>
							</tr>
							<s:iterator value="#request.allFolder" id="allFolder">
								<tr>
									<td align="center">
										<a
											href="enterFold1.action?file1.fileId=<s:property value="#allFolder.fileId"/>"><s:property
												value="#allFolder.fileName" /> </a>
									</td>
									<td align="center">
										<s:date name="#allFolder.modifiedDate" format="yyyy-MM-dd" />
									</td>
									<td align="center">
										<s:property value="#allFolder.ownPeopleId" />
									</td>
									<td align="center">
										<s:property value="#allFolder.filePath" />
									</td>
									<td align="center">
										<s:property value="#allFolder.kind" />
									</td>
									<td align="center">
										<s:property value="#dangwuFile.size" />
									</td>
									<td align="center">
										<s:if test="#allFolder.kind=='文件夹'">
											<a
												href="enterFold1.action?file1.fileId=<s:property value="#allFolder.fileId"/>"
												class="ico dcl">进入</a>
										</s:if>
										<s:else>
											<a
												href="download.action?file1.fileId=<s:property value="#allFolder.fileId"/>"
												class="ico dcl">下载</a>
										</s:else>

									</td>
								</tr>
							</s:iterator>

							<s:iterator value="#request.dangwuFile" id="dangwuFile">
								<tr>
									<td align="center">
										<s:property value="#dangwuFile.fileName" />
									</td>
									<td align="center">
										<s:date name="#dangwuFile.modifiedDate" format="yyyy-MM-dd" />
									</td>
									<td align="center">
										<s:property value="#dangwuFile.ownPeopleId" />
									</td>

									<td align="center">
										<s:property value="#dangwuFile.filePath" />
									</td>
									<td align="center">
										<s:property value="#dangwuFile.kind" />
									</td>
									<td align="center">i dcl
										<s:property value="#dangwuFile.size" />
									</td>
									<td align="center">
										<a
											href="download.action?file1.fileId=<s:property value="#dangwuFile.fileId"/>"
											class="ico dcl">下载</a>
									</td>
										<td align="center">
										<a
											href="viewFile.action?file1.fileId=<s:property value="#dangwuFile.fileId"/>"
											class=co"">查看</a>
									</td>
								</tr>
							</s:iterator>

						</table>


						<!-- 前进后退首页 -->
						<div class="pagging">
							<div class="right">
								<s:set name="page" value="#request.page"></s:set>
								<s:if test="#page.hasFirst">
									<a href="dangwu.action?pageNow=1">首页</a>
								</s:if>
								<s:if test="#page.hasPre">
									<a
										href="dangwu.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
								</s:if>
								<s:if test="#page.hasNext">
									<a
										href="dangwu.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
								</s:if>
								<s:if test="#page.hasLast">
									<a
										href="dangwu.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
								</s:if>
							</div>
						</div>
						<!-- End Pagging -->

					</div>
					<!-- Table -->
				</div>
				<!-- End Box -->
			</div>
		</div>
		<!-- End Content -->
	</body>
</html>
