<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<body>
		<s:form action="addUser.action" method="post">
			<s:submit value="添加用户" align="left"/>
		</s:form>
		
		<table width="400" border="1">
   			<caption>所有用户信息</caption>
   			<tr>
   				<th>员工号</th><th>用户组别号</th><th>用户名</th><th>所属部门编号</th>
				<th>职位</th><th>查看</th><th>修改</th><th>删除</th>
   			</tr>
   			<s:iterator value="#request.allUser" id="allUser">
				<tr>
					<td align="center"><s:property value="#allUser.peopleId"/></td>
					<td align="center"><s:property value="#allUser.groupNo"/></td>
					<td align="center"><s:property value="#allUser.peopleName"/></td>
					<td align="center"><s:property value="#allUser.departmentNo"/></td>
					<td align="center"><s:property value="#allUser.position"/></td>
					<td align="center">
					<a href="check.action?people.peopleId=<s:property value="#allUser.peopleId"/>">查看</a></td>
					<td align="center">
					<a href="edit.action?people1.peopleId=<s:property value="#allUser.peopleId"/>">修改</a></td>
					<td align="center">
					<a href="delete.action?people2.peopleId=<s:property value="#allUser.peopleId"/>">删除</a></td>
				</tr>   			
   			</s:iterator>
   			<tr>
			<s:set name="page" value="#request.page"></s:set>
  				<s:if test="#page.hasFirst">
				<s:a href="userManage.action?pageNow=1">首页</s:a>
				</s:if>
				<s:if test="#page.hasPre">
					<a href="userManage.action?pageNow=<s:property value="#page.pageNow-1"/>">上一页</a>
				</s:if>
				<s:if test="#page.hasNext">
					<a href="userManage.action?pageNow=<s:property value="#page.pageNow+1"/>">下一页</a>
				</s:if>
				<s:if test="#page.hasLast">
					<a href="userManage.action?pageNow=<s:property value="#page.totalPage"/>">尾页</a>
				</s:if>
		</tr>
   		</table>
	</body>
</html>