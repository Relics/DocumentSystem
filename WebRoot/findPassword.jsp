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
function load(){
		var value1=document.getElementById("isRight2").value;
		if(value1 == 'cuowu'){
			alert("邮件发送失败！");
		}else{
			alert("邮件发送成功~");
		}
}
</script>
		<link href="demo.css" rel="stylesheet" type="text/css" />
	</head>
	<body id="bg" onload="load()">
		<s:form action="findPassword.action" method="post">
			<div style="height: 200px"></div>
			<div class="loginBox">
				<h1>
					&nbsp软件学院文件管理系统
				</h1>
				<hr size="1" width="100%" color="white" noshade="noshade" />
				<h2>
					&nbspSSE Document Management System
				</h2>
				<br/>
				<h2>
					请输入您的用户名：
				</h2>
				<div class="inputBox">
					<label for="demo1">
						用户名
					</label>
					<input id="demo1" name="people.peopleId" type="text" />
				</div>
				<br/>
				<h2>
					点击“找回密码”，系统将会将密码发送至您的邮箱中。
				</h2>
				<button type="submit">
					找回密码
				</button>
				<s:if test="#session.key==1">
					<s:if test="#session.message1==1">
						<input type="hidden" value="cuowu" id="isRight2" name="isRight2"/>
					</s:if>
					<s:elseif test="#session.message1==0">
						<input type="hidden" value="zhengque" id="isRight2" name="isRight2"/>
					</s:elseif>
				</s:if>
			</div>
		</s:form>
	</body>

	<script type="text/javascript">
    function change(){
       flag=Math.round(Math.random()*8);
        var imgTemp= document.getElementById('bg');
        // 这里改路径
        package = "image/";
        imgTemp.style.background="url("+package+flag+".jpg)";;
        // 注意函数格式：function(){函数名}
        window.setTimeout(function(){change()},2000);
    }
    change();
  </script>
</html>
