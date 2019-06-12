<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<br />
<hr />
<br />

<table border="1">
	<tr>
		<th>选择</th>
		<th>书名</th>
		<th>作者</th>
		<th>描述</th>
		<th>单价</th>
		<th>出版社</th>
		<th>所属分类</th>
		<th>图片</th>
		<th>操作</th>
	</tr>


	<c:forEach items="${page.records}" var="b" varStatus="vs">
		<tr class="${vs.index%2 ==0?'odd':'even' }">
			<td><input type="checkbox" name="ids">
			</td>
			<td>${b.name}</td>
			<td>${b.author}</td>
			<td>${b.description}</td>
			<td>${b.price}</td>
			<td>${b.publish}</td>
			<%-- <td>${cs.name}</td> --%>
			<td>${am:showCategoryName(b.categoryId)}</td>
			<td><img src="${basePath}images${b.path}/${b.photoName}"
				width="100px" height="100px"></td>
			<td><a href="${basePath}servlet/ControlServlet?op=editBookView&bookId=${b.id}">修改</a> 
			<a href="${basePath}servlet/ControlServlet?op=delBook&bookId=${b.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="/common/page.jsp"%>
</body>
</html>
