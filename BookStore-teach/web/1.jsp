<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/1.jsp"  %>

<!--
 	jsp有三大指令
			page....
	jsp有九大内置(隐式)对象
				|--- 1. out				向客户端输出数据
				|--- 2. request			向客户端发出请求
				|--- 3. response		封装到jsp产生的响应，然后被发送到客户端用于回应客户的请求
				|--- 4. config			servlet 的配置
				|--- 5. exception		异常
				|--- 6. application		程序项目
				|--- 7. session			会话
				|--- 8. pageContext		上下文
				|--- 9. page			当前网页
 	jsp有四大作用域
 			request是一个域对象
 				|---  存入域中的方法是  request.setAttribute("xxx",xxx);
						|--- 生命周期： 浏览器发出请求时，仅仅一次有效...
 			session是一个域对象
 				|---  存入域中的方法是  session.setAttribute("xxx",xxx);
 						|--- 生命周期： 浏览器访问开始，到浏览器关闭之间有效... 默认时常30分钟 
	 						|---使用场景：在登录时，  将用户的登录信息存放在session域中 
	 						|---使用场景：在购物车中，  将用户的选择商品信息存放在session域中 
			pageContext是一个域对象
				|---  存入域中的方法是  pageContext.setAttribute("xxx",xxx);
						|--- 生命周期：作用域的范围是当期的jsp页面有效
			application是一个域对象
				|---  存入域中的方法是  application.setAttribute("xxx",xxx);
						|--- 生命周期：作用域的范围是当期的程序项目中全部范围内有效
				pageContext		request  session   application
			
			会话对象
				|--- cookie的缓存信息  是存放在 本地浏览器端
				|--- session的缓存信息  是存放在 服务器端
						|--- 生命周期： 浏览器的开始到结束
					+ redis
			
  jstl  标准标签库 有五种类库
	|--core  核心类库
		|--- 标签
			  |--- 判断标签 c:if	
			  |--- 循环标签 c:foreach	
			  ....
			  
			  xml 
			  tomcat  服务器
			  Filter	过滤器
			  Listener
  -->

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>分类列表</title>
    <style>
    	table{
    		text-align: center;
    		font-size: 12px;
    	}
    </style>
  </head>