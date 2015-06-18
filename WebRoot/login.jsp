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
			alert("用户名或密码输入错误！");
		}

	}
</script>
		<link href="demo.css" rel="stylesheet" type="text/css" />
	</head>
	<body id="bg" onload="load()">
		<s:form action="login.action" method="post">
			<div style="height: 200px"></div>
			<div class="loginBox">
				<h1>
					&nbsp软件学院文件管理系统
				</h1>
				<hr size="1" width="100%" color="white" noshade="noshade" />
				<h2>
					&nbspSSE Document Management System
				</h2>
				<div class="inputBox">
					<label for="demo1">
						用户名
					</label>
					<input id="demo1" name="people.peopleId" type="text" value="" />
				</div>
				<div class="inputBox">
					<label for="demo2">
						密码
					</label>
					<input id="demo2" name="people.password" type="password" value="" />
				</div>
				<button type="submit">
					登&nbsp&nbsp&nbsp录
				</button>
				<s:if test="#request.message==1">
					<input type="hidden" value="cuowu" id="isRight" name="isRight" />
				</s:if>
				<s:else>
					<input type="hidden" value="zhengque" id="isRight" name="isRight" />
				</s:else>


				<button type="submit">
					<a href="findPassword1.action"> <font color="#ffffff">
							忘记密码？ </font> </a>
				</button>
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
