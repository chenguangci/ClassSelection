<%@ page import="com.cgc.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生信息</title>
</head>
<body>
    <%
        Student student = ((List<Student>) request.getAttribute("students")).get(0);
    %>
    <form action="updateStudent.action" method="post">
        <input type="hidden" name="studentNo" value="<%=student.getStudentNo()%>">
        学号：<%=student.getStudentNo()%><br>
        姓名：<input type="text" name="name" value="<%=student.getStudentName()%>"><br>
        性别：<select name="sex">
        <%
            if ("男".equals(student.getStudentSex())) {
        %>
        <option value="男" selected>男</option><option value="女">女</option>
        <%
            } else {

        %>
        <option value="男">男</option><option value="女" selected>女</option>
        <%
            }
        %>
        </select><br>
        年龄：<input type="text" name="age" value="<%=student.getStudentAge()%>"><br>
        系编号：<input type="text" name="departmentNo" value="<%=student.getDepartmentNo()%>"><br>
        <input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
    </form>
</body>
</html>
