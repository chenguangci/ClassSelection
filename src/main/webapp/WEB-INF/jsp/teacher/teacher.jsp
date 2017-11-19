<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Student" %>
<%@ page import="com.cgc.bean.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
</head>
<body>
<form method="post" action="selectTeacher.action">
    教师编号：<input type="text" name="teacherNo">&nbsp;&nbsp;
    教师姓名：<input type="text" name="teacherName">&nbsp;&nbsp;
    性别：<select name="teacherSex"><option value="">全部</option><option value="男">男</option><option value="女" >女</option></select><br>
    年龄：<input type="text" name="teacherAge">&nbsp;&nbsp;
    学历：<select name="education"><option value="">全部</option><option value="学士">学士</option><option value="硕士">硕士</option><option value="博士">博士</option></select> &nbsp;&nbsp;
    职称：<select name="title"><option value="">全部</option><option name="助教">助教</option><option name="讲师">讲师</option><option name="副教授">副教授</option><option name="教授">教授</option></select> &nbsp;&nbsp;
    授课课程编号：<input type="text" name="course"><br>
    <input type="submit" value="查看">
</form>
<a href="selectTeacher.action?insert=1">添加教师信息</a>
<table border="1px">
    <tr>
        <td>序号</td>
        <td>教师编号</td>
        <td>教师姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>学历</td>
        <td>职称</td>
        <td>所授课程1</td>
        <td>所授课程2</td>
        <td>所授课程3</td>
        <td>操作</td>
    </tr>
    <%
        List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
        for (int i=0;i<teachers.size();i++) {
            out.print("<tr>");
            out.print("<td>" + (i+1) + "</td>");
            out.print("<td>" + teachers.get(i).getTeacherNo() + "</td>");
            out.print("<td>" + teachers.get(i).getTeacherName() + "</td>");
            out.print("<td>" + teachers.get(i).getTeacherSex() + "</td>");
            out.print("<td>" + teachers.get(i).getTeacherAge() + "</td>");
            out.print("<td>" + teachers.get(i).getEducation() + "</td>");
            out.print("<td>" + teachers.get(i).getProfessionalTitle() + "</td>");
            out.print("<td>" + teachers.get(i).getCourseNo1() + "</td>");
            out.print("<td>" + teachers.get(i).getCourseNo2() + "</td>");
            out.print("<td>" + teachers.get(i).getCourseNo3() + "</td>");
    %>
    <td>
        <a href="<%=request.getContextPath()%>/deleteTeacher.action?teacherNo=<%=teachers.get(i).getTeacherNo()%>">删除</a>&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/selectTeacher.action?teacherNo=<%=teachers.get(i).getTeacherNo()%>&update=1">修改</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>