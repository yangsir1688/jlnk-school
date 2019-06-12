<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<br/>
	<hr/>
	<br/>
	<form action="${basePath}servlet/ControlServlet?op=userRegister"
		method="post">

		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password">
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" value="man" name="sex"checked="checked">男 
					<input type="radio" value="woman" name="sex">女
				</td>
			</tr>
			<tr>
   					<td>角色:</td>
   					<td>
   						普通用户<input type="radio" name="type" value="普通用户" checked="checked" >
   					</td>
   				</tr>
			<tr>
				<td colspan="2"><input type="submit" value="免费注册">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>
