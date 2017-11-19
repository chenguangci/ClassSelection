<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
</head>
<body>
<form method="post" action="selectCourse.action">
    课程编号：<input type="text" name="courseNo">&nbsp;&nbsp;
    课程名称：<input type="text" name="courseName"><br>
    先修课程号：<input type="text" name="coursePriorNo">&nbsp;&nbsp;
    课程学分：<input type="text" name="courseCredit"><br>
    <input type="submit" value="查看">
</form>
<a href="selectCourse.action?insert=1">添加课程信息</a>
<table border="1px">
    <tr>
        <td>序号</td>
        <td>课程号</td>
        <td>课程名称</td>
        <td>先修课程号</td>
        <td>课程学分</td>
        <td>操作</td>
    </tr>
    <%
        List<Course> courses = (List<Course>) request.getAttribute("courses");
        for (int i=0; i<courses.size();i++) {
            out.print("<tr>");
            out.print("<td>"+(i+1)+"</td>");
            out.print("<td>"+courses.get(i).getCourseNo()+"</td>");
            out.print("<td>"+courses.get(i).getCourseName()+"</td>");
            out.print("<td>"+courses.get(i).getCoursePriorNo()+"</td>");
            out.print("<td>"+courses.get(i).getCourseCredit()+"</td>");
    %>
            <td>
                <a href="<%=request.getContextPath()%>/deleteCourse.action?courseNo=<%=courses.get(i).getCourseNo()%>">删除</a>&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/selectCourse.action?courseNo=<%=courses.get(i).getCourseNo()%>&update=1">修改</a>
            </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
