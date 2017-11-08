<%--
  Created by IntelliJ IDEA.
  User: BeiYi
  Date: 2017/11/7
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课信息</title>
</head>
<body>
<form method="post" action="/student.action">
    学号：<input type="text" name="studentNo"><br>
    姓名：<input type="text" name="Name"><br>
    性别：<input type="text" name="sex"><br>
    年龄：<input type="text" name="age"><br>
    系编号：<input type="text" name="departmentNo"><br>
    <input type="submit" value="查看">
</form>
</body>
</html>
