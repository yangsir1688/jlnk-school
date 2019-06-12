<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"  %>
<br/>
<hr/>
<br/>
	<!--${pageContext.request.contextPath}是为了获取这个路径：http://localhost:8888/bookstore -->
	<form action="${pageContext.request.contextPath}/servlet/ControlServlet?op=editCategory&id=${c.id}" method="post" >
		<table border="1">
			<!-- 第1行  -->
			<tr>
				<td>分类名称</td>
				<td><input type="text" name="name" value="${c.name}" ></td>
			</tr>
			<!-- 第2行  -->
			<tr>
				<td>分类描述</td>
				<td><textarea rows="3" cols="15" name="description"  >${c.description} </textarea>
				</td>
			</tr>
			<!-- 第3行  -->
			<tr>
				<td colspan="2"><input type="submit" value="编辑分类"></td>
			</tr>
		</table>
	</form>
</body>
</html>
