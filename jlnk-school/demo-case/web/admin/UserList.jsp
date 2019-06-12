<%--
  Created by IntelliJ IDEA.
  User: Mryang
  Date: 2019/6/11
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--jstl 标准标签库--%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <table border="1" width="438">
        <c:forEach items="${list}"  var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.username}</td>
                <td>${l.birthday}</td>
                <td>
                    <a href="JavaScript:delUser('${l.id}')">删除</a>
                    <a href="${pageContext.request.contextPath}/userServlet?op=editUser&id=${l.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
<script>
    function  delUser(id) {
       var sure = confirm("你确定要删除吗?");
       if(sure){
         window.location.href="${pageContext.request.contextPath}/userServlet?op=delUser&id="+id;
       }else {
           alert("NoOk")
       }
    }
</script>