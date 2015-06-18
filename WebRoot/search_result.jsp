
<%@page language="java" pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>文件管理系统</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="all" />
		<link rel="stylesheet" href="css/style1.css" type="text/css"
			media="all" />
	</head>
	<body>
		<!-- Content -->
		<div id="content" style="width: 99%">
			<!-- Box -->
			<div class="box">
				<!-- Box Head -->
				<div class="box-head">
					<h2 class="left">
						搜索结果
					</h2>
					<div class="right">
						<form action="search.action" method="post">
							<input type="text" name="searchName" size="50" class="field small-field"/>
							<input type="submit" value="查找" method="search" class="button"/>
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
						</tr>
						<s:iterator value="#request.searchList" id="searchList">
							<tr>
								<td align="center">
									<s:property value="#searchList.fileName" />
								</td>
								<td align="center">
									<s:date name="#searchList.modifiedDate" format="yyyy-MM-dd" />
								</td>
								<td align="center">
									<s:property value="#searchList.ownPeopleId" />
								</td>
								<td align="center">
									<s:property value="#searchList.filePath" />
								</td>
								<td align="center">
									<s:property value="#searchList.kind" />
								</td>
								<td align="center">
									<s:property value="#searchList.size" />
								</td>
								<td align="center">
									<a
										href="download.action?file1.fileId=<s:property value="#searchList.fileId"/>"
										class="ico dcl">下载</a>
								</td>
								<td align="center">
									<a
										href="viewFile.action?file1.fileId=<s:property value="#searchList.fileId"/>"
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
								<a href="searchList.action?pageNow=1">首页</a>
							</s:if>
							<s:if test="#page.hasPre">
								<a
									href="searchList.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
							</s:if>
							<s:if test="#page.hasNext">
								<a
									href="searchList.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
							</s:if>
							<s:if test="#page.hasLast">
								<a
									href="searchList.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
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
