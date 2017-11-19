<%--
  Created by IntelliJ IDEA.
  User: BeiYi
  Date: 2017/11/7
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <style type="text/css">
        form{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="login.action" method="post">
    用户名：<input type="text" name="username"><br>
    密&nbsp;&nbsp;码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
