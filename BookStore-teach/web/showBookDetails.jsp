<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
 <br/>
 <br/>
    <img src="${basePath}images${b.path}/${b.photoName}"
				width="100px" height="100px"> <br/><br/>
	
	${b}
	
	<br/>
	<br/>
	<A href="${basePath}servlet/ControlServlet?op=buyBook&bookId=${b.id}">放入购物车</A>
	<A href="javascript:history.back()">继续购物</A>
  </body>
</html>
