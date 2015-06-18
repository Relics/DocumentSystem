<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Free CSS template by ChocoTemplates.com</title>
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="all" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<body>
		<s:set name="file1" value="#request.fileInfo"></s:set>
		<!-- 上传文件时要加入黑体部分-->
		<form
			action="updateFile.action?file1.fileId=<s:property value="#file1.fileId"/>"
			method="post">

			<div id="container" position="absolute"
				style="padding: 0; margin: 0;">
				<div class="shell">
					<!-- Main -->
					<div id="main">
						<!-- Box -->
						<div class="box">
							<!-- Box Head -->
							<div class="box-head">
								<h2>
									修改文件信息
								</h2>
							</div>
							<!-- End Box Head -->

							<!-- Form -->
							<div class="form">

								<label>
									文件名
								</label>

								<input type="text" name="file1.fileName" class="field size1"
									value="<s:property value="#request.qianzhui"/>" />
								<s:property value="#request.houzhui" />
								<br />

								<br />
								<br />
								<label>
									选择可以查看本文件的部门
								</label>
								<br />

								<span style="margin: 10 30 10 50"> <s:if
										test="#request.caiwu=='财务'">
										<input name="checkBox" type="checkbox" value="财务部门" checked>财务部门
	  					
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="财务部门">财务部门
	  				
	  					</s:else> </span>

								<span style="margin: 10 30 10 50"> <s:if
										test="#request.jiaowu=='教务'">
										<input name="checkBox" type="checkbox" value="教务部门" checked>教务部门
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="教务部门">教务部门
	  					</s:else> </span>

								<span style="margin: 10 30 10 50"> <s:if
										test="#request.dangwu=='党务'">
										<input name="checkBox" type="checkbox" value="党务部门" checked>党务部门	
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="党务部门">党务部门
	  					</s:else> </span>

								<span style="margin: 10 30 10 50"> <s:if
										test="#request.zichan=='资产'">
										<input name="checkBox" type="checkbox" value="资产部门" checked>资产部门
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="资产部门">资产部门
	  					</s:else> </span>
	<br />
								<br />

								<span style="margin: 10 30 10 50"> <s:if
										test="#request.gonghui=='工会'">
										<input name="checkBox" type="checkbox" value="工会部门" checked>工会部门
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="工会部门">工会部门
	  					</s:else> </span>


								<span style="margin: 10 30 10 50"> <s:if
										test="#request.xuesheng=='学生'">
										<input name="checkBox" type="checkbox" value="学生部门" checked>学生部门
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="学生部门">学生部门
	  					</s:else> </span>


								<span style="margin: 10 30 10 50"> <s:if
										test="#request.jiaozhigong=='教职工'">
										<input name="checkBox" type="checkbox" value="教职工部门" checked>教职工部门
	  					</s:if> <s:else>
										<input name="checkBox" type="checkbox" value="教职工部门">教职工部门
	  					</s:else> </span>
								<label>
								<br/>
								<br/>
									最近一次修改时间：
									<s:date name="#file1.modifiedDate"
										format="yyyy-MM-dd" />
								</label>
							</div>
							<!-- End Box -->
							<p>
				
						<!-- End Form -->
						<!-- Form Buttons -->
						<div class="buttons">
							<input type="submit" class="button2" value="确认修改" />
						</div>
						<!-- End Form Buttons -->
		</div>
					</div>

					<!-- End Box -->
				</div>
				<!-- End Content -->
			</div>
			<!-- Main -->
			<!-- End Container -->
		</form>

	</body>
</html>
