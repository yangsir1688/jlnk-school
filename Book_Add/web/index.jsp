<%--
  Created by IntelliJ IDEA.
  User: Mryang
  Date: 2019/5/28
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="js/jquery-1.7.2.min.js"></script>
  <body>
<form id="myForm">
  用户名：<input type="text" name="username" >
  <br/>
  密码：<input type="text" name="password" >
  <br/>
  性别：<input type="text" name="sex" >  <br/>
  <input type="button" id="btn" value="添加用户" >
</form>
  <table>
    <tr>
      <td>1</td>
      <td>2</td>
    </tr>
    <c:forEach items="${list}" var="l" >
        <tr>
          <td>${l.username}</td>
        </tr>
    </c:forEach>
  </table>
  </body>
</html>
<script>
  $(function () {
      $("#btn").click(function () {
          $.ajax({
              url:"/userServlet",
              type:"post",
              data:$("#myForm").serialize(),
              success:function (data) {
                  alert(data);
              },
              error:function (data) {
                  alert(data)
              }
          });
      });
  });
</script>