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
				action="upload.action?tempId=<s:property value="#request.fileId"/>"
				method="post" enctype="multipart/form-data">
		<div id="container" position="absolute" style="padding:0;margin:0;">
			<div class="shell"> 
				<!-- Main -->
				<div id="main">
					<!-- Box -->
					<div class="box">
						<!-- Box Head -->
						<div class="box-head">
							<h2>
								文件上传
							</h2>
						</div>
						<!-- End Box Head -->
							<!-- Form -->
							<div class="form">
								<label>
									文件所在文件夹：
								</label>
								<input type="text" class="field size1" value="<s:property value="#request.path"/>"
									readOnly />
								<br />
								<label>
									选择文件
								</label>
								<input type="file" name="upload" id="fileUpload">
								<br />
								<br />
								<label>
									文件类别
								</label>
					

								<select name="file1.kind" size="1" style="width: 100">
									<option value="文档">
										文档
									</option>
									<option value="图片">
										图片
									</option>
									<option value="视频">
										视频
									</option>
								</select>
								<br />
								<br />
									<br />
								<label>
									选择可以查看本文件的部门
								</label>
								<br />
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="财务部门" checked> 财务部门 </span>
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="教务部门" checked> 教务部门 </span>
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="党务部门" checked> 党务部门 </span>
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="资产部门" checked> 资产部门 </span>
								<br />
								<br />
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="工会部门" checked> 工会部门 </span>
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="学生部门" checked> 学生部门 </span>
								<span style="margin: 10 30 10 50"> <input name="checkBox"
										type="checkbox" value="教职工部门" checked> 教职工部门 </span>
								<br/>
								
								<!-- End Box -->
								<p>
							</div>
							<!-- End Form -->
							<!-- Form Buttons -->
							<div class="buttons">
								<input type="submit" class="button2" value="上传" />
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