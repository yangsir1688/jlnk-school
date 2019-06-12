<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<br/>
<br/>
   <a href="${basePath}"> 所有分类</a>：
   <c:forEach items="${cs}" var="c"  >
   		<a href="${basePath}servlet/ControlServlet?op=showCategoryBooks&categoryId=${c.id}">${c.name}</a>
   </c:forEach>
   
   	<table border="1" >
   		<tr>
		<c:forEach items="${page.records}" var="b">
			<td><a
				href="${basePath}servlet/ControlServlet?op=showBookDetails&bookId=${b.id}">
					<img src="${basePath}images${b.path}/${b.photoName}" width="100px"
					height="100px"> </a><br /> 书名: ${b.name }<br /> 作者: ${b.author }<br />
				出版社: ${b.publish }<br /> 售价: ${b.price }<br /> <a
				href="${basePath}servlet/ControlServlet?op=showBookDetails&bookId=${b.id}">查看详细
			</a></td>
		</c:forEach>
	</tr>
   	</table>
   <br/>
<br/>
   <%@ include file="/common/page.jsp" %>
  </body>
</html>
