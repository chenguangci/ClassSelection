<%@ page import="com.cgc.bean.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: BeiYi
  Date: 2017/11/19
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新院系信息</title>
</head>
<body>
<%
    Department department = ((List<Department>)request.getAttribute("departments")).get(0);
%>
<form action="updateCourse.action" method="post">
    <input type="hidden" name="departmentNo" value="<%=department.getDepartmentNo()%>">
    院系编号：<%=department.getDepartmentNo()%><br>
    院系名称：<input type="text" name="departmentName" value="<%=department.getDepartmentName()%>"><br>
    院系主任：<input type="text" name="manager" value="<%=department.getManager()%>"><br>
    <input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
</form>
</body>
</html>
