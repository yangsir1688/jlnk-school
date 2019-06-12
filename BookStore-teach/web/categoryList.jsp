<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"  %>
<br/>
<hr/>
<br/>

   		<table border="1" >
   			<tr>
   				<th>选择</th>
   				<th>分类名称</th>
   				<th>分类描述</th>
   				<th>操作</th>
   			</tr>
   			
   			<!-- 属于jsp的标准标签库中的 循环标签 -->
   				<!-- items： 条、项 -->
   			<c:forEach items="${cs}" var="c" >
   				<tr>
   					<td>
   						<input type="checkbox" name="ids" >
   					</td>
   					<td>
   						${c.name }
   					</td>
   					<td>
   						${c.description }
   					</td>
   					<td>
   						<a href="${basePath}servlet/ControlServlet?op=editCategoryView&categoryId=${c.id}">修改</a>
   						<a href="${basePath}servlet/ControlServlet?op=delCategory&categoryId=${c.id}">删除</a>
   					</td>
   				</tr>
   			</c:forEach>
   		</table>
  </body>
</html>
