<%@ page import="com.cgc.bean.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: BeiYi
  Date: 2017/11/19
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新课程信息</title>
</head>
<body>
    <%
        Course course = ((List<Course>)request.getAttribute("courses")).get(0);
    %>
    <form action="updateCourse.action" method="post">
        <input type="hidden" name="courseNo" value="<%=course.getCourseNo()%>">
        课程号：<%=course.getCourseNo()%><br>
        课程名称：<input type="text" name="courseName" value="<%=course.getCourseName()%>"><br>
        先修课程号：<input type="text" name="coursePriorNo" value="<%=course.getCoursePriorNo()%>"><br>
        课程学分：<input type="text" name="courseCredit" value="<%=course.getCourseCredit()%>"><br>
        <input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
    </form>
</body>
</html>
