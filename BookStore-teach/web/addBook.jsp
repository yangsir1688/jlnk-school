<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<br/>
	<hr/>
	<br/>
	<!--
		文件上传时：
			|--- 表单中必须要采用的方式 enctype
	  -->
	<form action="${basePath}servlet/ControlServlet?op=addBook" method="post" enctype="multipart/form-data" >
		<table border="1">
			<tr>
				<td>书名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>单价</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="photoname"></td>
			</tr>
			<tr>
				<td>图片预览</td>
				<td><img src="${basePath}images${b.path}/${b.photoName}" ></td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><input type="text" name="publish"></td>
			</tr>
			<tr>
				<td>分类</td>
				<td><select name="categoryId">
					<c:forEach items="${cs}" var="c" >
						<option value="${c.id}" >${c.name}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加图书"></td>
			</tr>
		</table>
	</form>
</body>
</html>
