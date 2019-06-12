<%--
  Created by IntelliJ IDEA.
  User: Mryang
  Date: 2019/6/12
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
我是登录后、要进入的主页面
<hr/>
${sessionScope.USER_SESSION.username}，你好！
<a href="JavaScript:exit()">注销</a>
</body>
</html>
<script>
    function exit() {
       var sure = confirm("您确定要退出吗?");
       if(sure){
           location="${pageContext.request.contextPath}/userServlet?op=userLogout";
       }else{

       }
    }
</script>