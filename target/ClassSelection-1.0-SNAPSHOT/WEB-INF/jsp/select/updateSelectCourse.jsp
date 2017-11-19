<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.SelectCourse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新选课信息</title>
</head>
<body>
<%
    SelectCourse selectCourse = ((List<SelectCourse>)request.getAttribute("selects")).get(0);
%>
<form action="updateCourse.action" method="post">
    <input type="hidden" name="departmentNo" value="<%=selectCourse.getStudentNo()%>">
    学号：<input type="text" name="studentNo" value="<%=selectCourse.getStudentNo()%>"><br>
    课程号：<input type="text" name="courseNo" value="<%=selectCourse.getCourseNo()%>"><br>
    教师号：<input type="text" name="teacherNo" value="<%=selectCourse.getTeacherNo()%>"><br>
    学分：<input type="text" name="grade" value="<%=selectCourse.getGrade()%>"><br>
    <input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
</form>
</body>
</html>