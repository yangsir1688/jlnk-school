<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<br/>
	<hr/>
	<br/>
   		<form action="${basePath}servlet/ControlServlet?op=userLogin" method="post">
   			<table border="1">
   				<tr>
   					<td>用户名:</td>
   					<td>
   						<input type="text" name="username">
   					</td>
   				</tr>
   				<tr>
   					<td>密码:</td>
   					<td>
   						<input type="password" name="password">
   					</td>
   				</tr>
   				<tr>
   					<td>角色:</td>
   					<td>
   						普通用户<input type="radio" name="type" value="普通用户" checked="checked" >
   						管理员<input type="radio" name="type"value="管理员" >
   					</td>
   				</tr>
   				<tr>
   					<td colspan="2">
   						<input type="submit" value="快速登录">
   					</td>
   				</tr>
   			</table>
   		</form>
  </body>
</html>
