<%@page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>文件管理系统</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style1.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="all" />
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
												action="upload2.action?file1.fileId=<s:property value="#request.fileId"/>"
												method="post">
												<input type="submit" class="add-button" value="文件上传"
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
		<div id="content" style="width: 99%">
			<!-- Box -->
			<div class="box">
				<!-- Box Head -->
				<div class="box-head">

					<form action="search.action" method="post" class="right">
						<input type="text" name="searchName" size="50"
							class="field small-field" />
						<input type="submit" method="search" class="button" value="查找" />
					</form>
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
								修改
							</th>
							<th align="center">
								下载
							</th>
							<th align="center">
									查看
								</th>
						</tr>
						<s:iterator value="#request.allFile" id="allFile">
							<tr>
								<td align="center">
									<s:property value="#allFile.fileName" />
								</td>
								<td align="center">
									<s:date name="#allFile.modifiedDate" format="yyyy-MM-dd" />
								</td>
								<td align="center">
									<s:property value="#allFile.ownPeopleId" />
								</td>
								<td align="center">
									<s:property value="#allFile.filePath" />
								</td>

								<td align="center">
									<s:property value="#allFile.kind" />
								</td>
								<td align="center">
									<s:property value="#allFile.size" />
								</td>
								<td align="center">
									<a
										href="changeInfo.action?file1.fileId=<s:property value="#allFile.fileId"/>"
										class="ico dcl">编辑 </a>
								</td>


								<td align="center">
									<a
										href="download.action?file1.fileId=<s:property value="#allFile.fileId"/>"
										class="ico dcl">下载</a>
								</td>
								<td align="center">
										<a
											href="viewFile.action?file1.fileId=<s:property value="#allFile.fileId"/>"
											class="ico dcl">查看</a>
									</td>
							</tr>
						</s:iterator>

					</table>


					<!-- 前进后退首页 -->
					<div class="pagging">
						<div class="right">
							<s:set name="page" value="#request.page"></s:set>
							<s:if test="#page.hasFirst">
								<a href="allFile.action?pageNow=1">首页</a>
							</s:if>
							<s:if test="#page.hasPre">
								<a
									href="allFile.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
							</s:if>
							<s:if test="#page.hasNext">
								<a
									href="allFile.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
							</s:if>
							<s:if test="#page.hasLast">
								<a
									href="allFile.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
							</s:if>
						</div>
					</div>
					<!-- End Pagging -->

				</div>
				<!-- Table -->
			</div>
			<!-- End Box -->

			<!-- End Content -->
	</body>
</html>
