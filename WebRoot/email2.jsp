<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script src="jquery.min.js"></script>
		<script type="text/javascript" src="iPass.packed.js"></script>
		<script type="text/javascript">
$(document).ready(function(){	
	// to enable iPass plugin
	$("input[type=password]").iPass();
});
</script>
		<script type="text/javascript">
	function load(){
		var value = document.getElementById("isRight").value;
		if(value == 'cuowu'){	
			alert("邮件发送失败！");
		}else{
			alert("邮件发送成功~");
		}
	}
</script>
		<link href="email.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<s:if test="#request.emailMessage==1">

			<input type="hidden" value="cuowu" id="isRight" name="isRight" />
		</s:if>
		<s:else>
			<input type="hidden" value="zhengque" id="isRight" name="isRight" />
		</s:else>
		<s:form action="feedback.action" method="post">

			<div class="inputBox">
				<label for="demo1">
					收件人
				</label>
				<input id="demo1" name="emailTo" type="text"
					value="buptgogame@163.com" readOnly />
			</div>
			<div class="inputBox">
				<label for="demo1">
					主题
				</label>
				<input id="demo1" name="subject" type="text" value="用户反馈" />
			</div>
			<div class="inputBox">
				<label for="demo2">
					请将您的建议写在下面……
				</label>
				<br />
				<textarea id="demo2" name="content"></textarea>
			</div>
			<button type="submit" onclick="load()">
				发送邮件
			</button>
		</s:form>
	</body>
</html>
