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
			action="saveFold.action?newFolder=<s:property value="#request.filePath"/>"
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
									新建文件夹
								</h2>
							</div>
							<!-- End Box Head -->

							<!-- Form -->
							<div class="form">
								<label>
									文件夹所在路径
								</label>

								<input type="text" class="field size1"
									value="<s:property value="#request.path"/>" readOnly />
								<br />
								<label>
									文件夹名称

								</label>
								<input type="text" name="newFoldName"
									value="<s:property value="#newFoldName"/>" class="field size1" />
								<br>
								<p>

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
				</div>
			</div>
		</form>
	</body>
</html>
