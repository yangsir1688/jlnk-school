<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
  <!--
	  此处的msg是在controlServlet中自个设置的一个标记；就是msg ，此处就取它。
	  刀2   这种形式 专业术语称之为 “EL表达式”
  -->
   	<center>
   		<h1>	${msg }</h1>
   	</center>
  </body>
</html>
