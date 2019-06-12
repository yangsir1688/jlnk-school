<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="am" uri="http://bianyige.com/javabs" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <link rel="stylesheet" href="css/main.css" type="text/css"></link>
  </head>
  
  <body>
 
 
<h3> 	${sessionScope.u.username},您好。欢迎来到xxx,您可以选择
</h3>
 	
 	
 	 <a href="${basePath}">网站主页</a>
     <a href="${basePath}addCategory.jsp">添加分类</a>
     <a href="${basePath}servlet/ControlServlet?op=findAllCategory">查询分类</a>
     <a href="${basePath}servlet/ControlServlet?op=addBookView">添加图书</a>
     <a href="${basePath}servlet/ControlServlet?op=showBook">查询图书</a>
     <a href="${basePath}showCart.jsp">购物车</a>
     
     <!--  
     	session域 中的标记 u  如果 为空 表示没有登录
     							|--- 则显示 用户注册和用户登录
     -->
     <c:if test="${sessionScope.u==null}">
     	<a href="${basePath}register.jsp">用户注册</a>
	     <a href="${basePath}login.jsp">用户登录</a>
     </c:if>
     
     <!--  
     	session域 中的标记 u  如果 为不空 表示已登录
     							|--- 则显示 用户注销
     -->
     <c:if test="${sessionScope.u!=null}">
	     <a href="${basePath}servlet/ControlServlet?op=logout">用户注销</a>
      </c:if>
     
     
     
     
     
     
     
     
     
     
     
     
     