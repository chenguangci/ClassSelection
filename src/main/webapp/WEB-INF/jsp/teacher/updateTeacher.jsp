<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新教师信息</title>
</head>
<body>
<a href="selectTeacher.action">返回</a>
<%
    Teacher teacher = ((List<Teacher>) request.getAttribute("teachers")).get(0);
%>
<form action="updateTeacher.action" method="post">
    <input type="hidden" name="teacherNo" value="<%=teacher.getTeacherNo()%>">
    教师编号：<%=teacher.getTeacherNo()%><br>
    姓名：<input type="text" name="teacherName" value="<%=teacher.getTeacherName()%>"><br>
    性别：<select name="teacherSex">
    <%
        if ("男".equals(teacher.getTeacherSex())) {
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
    年龄：<input type="text" name="teacherAge" value="<%=teacher.getTeacherAge()%>"><br>
    学历：<select name="education">
    <%
        if ("学士".equals(teacher.getEducation())) {
    %>
    <option value="学士" selected>学士</option><option value="硕士">硕士</option><option value="博士">博士</option>
    <%
        } else if("博士".equals(teacher.getEducation())){
    %>
    <option value="学士">学士</option><option value="硕士">硕士</option><option value="博士" selected>博士</option>
    <%
        } else if ("硕士".equals(teacher.getEducation())){
    %>
    <option value="学士">学士</option><option value="硕士" selected>硕士</option><option value="博士">博士</option>
    <%
        }
    %>
    </select><br>
    职称：<select name="title">
    <%
        if ("助教".equals(teacher.getProfessionalTitle())) {
    %>
    <option name="助教" selected>助教</option><option name="讲师">讲师</option><option name="副教授">副教授</option><option name="教授">教授</option>
    <%
    } else if("讲师".equals(teacher.getProfessionalTitle())){
    %>
    <option name="助教">助教</option><option name="讲师" selected>讲师</option><option name="副教授">副教授</option><option name="教授">教授</option>
    <%
    } else if ("副教授".equals(teacher.getProfessionalTitle())){
    %>
    <option name="助教">助教</option><option name="讲师">讲师</option><option name="副教授" selected>副教授</option><option name="教授">教授</option>
    <%
    } else if ("教授".equals(teacher.getProfessionalTitle())){
    %>
    <option name="助教">助教</option><option name="讲师">讲师</option><option name="副教授">副教授</option><option name="教授" selected>教授</option>
    <%
        }
    %>
    </select><br>
    所授课程1：<input type="text" name="course1" value="<%=teacher.getCourseNo1()%>"><br>
    所授课程2：<input type="text" name="course2" value="<%=teacher.getCourseNo2()%>"><br>
    所授课程3：<input type="text" name="course3" value="<%=teacher.getCourseNo3()%>"><br>
    <input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置">
</form>
</body>
</html>
