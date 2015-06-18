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
		<form
			action="updateFolder.action?file1.fileId=<s:property value="#request.tempFile.fileId"/>"
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
									文件原名：
									<s:property value="#request.tempFile.fileName" />
								</label>
								<br/>
								<label>
									文件新名
								</label>
								<input type="text" name="file1.fileName" class="field size1"
									value="<s:property value="#file1.fileName"/>" />
								<br />
								<br />
								<label>
									最近一次修改时间：
									<s:date name="#request.tempFile.modifiedDate"
										format="yyyy-MM-dd" />
								</label>

							</div>
							<!-- End Form -->
							<!-- Form Buttons -->
							<div class="buttons">
								<input type="submit" class="button2" value="确认" />
							</div>
							<!-- End Form Buttons -->

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
