<%@ page import="com.cgc.bean.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
    <script src="resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page){
            $("#page").val(page);
            $("#show").submit();
        }
    </script>
</head>
<body>
<form id="show" method="post" action="selectTeacher.action">
    教师编号：<input type="text" name="teacherNo" value="<%=request.getAttribute("teacherNo")==null?"":request.getAttribute("teacherNo")%>">&nbsp;&nbsp;
    教师姓名：<input type="text" name="teacherName" value="<%=request.getAttribute("teacherName")==null?"":request.getAttribute("teacherName")%>">&nbsp;&nbsp;
    <%
        if (request.getAttribute("sex")==null||"".equals(request.getAttribute("sex"))) {
    %>
    性别：<select name="sex"><option value="" selected>全部</option><option value="男">男</option><option value="女" >女</option></select><br>
    <%
    } else if ("男".equals(request.getAttribute("sex"))){
    %>
    性别：<select name="sex"><option value="">全部</option><option value="男" selected>男</option><option value="女">女</option></select><br>
    <%
    } else if ("女".equals(request.getAttribute("sex"))){
    %>
    性别：<select name="sex"><option value="">全部</option><option value="男">男</option><option value="女" selected>女</option></select><br>
    <%
        }
    %>
    年龄：<input type="text" name="teacherAge" value="<%=request.getAttribute("teacherAge")==null?"":request.getAttribute("teacherAge")%>">&nbsp;&nbsp;
    学历：<select name="education">
    <%
        if (request.getAttribute("education")==null||"".equals(request.getAttribute("education"))) {
    %>
    <option value="" selected>全部</option><option value="学士">学士</option><option value="硕士">硕士</option><option value="博士">博士</option>
    <%
    } else if ("学士".equals(request.getAttribute("education"))) {
    %>
    <option value="">全部</option><option value="学士" selected>学士</option><option value="硕士">硕士</option><option value="博士">博士</option>
    <%
    } else if("博士".equals(request.getAttribute("education"))){
    %>
    <option value="">全部</option><option value="学士">学士</option><option value="硕士">硕士</option><option value="博士" selected>博士</option>
    <%
    } else if ("硕士".equals(request.getAttribute("education"))){
    %>
    <option value="">全部</option><option value="学士">学士</option><option value="硕士" selected>硕士</option><option value="博士">博士</option>
    <%
        }
    %>
</select> &nbsp;&nbsp;
    职称：<select name="title">
    <%
        if (request.getAttribute("title")==null||"".equals(request.getAttribute("title"))){
    %>
    <option value="" selected>全部</option><option value="助教">助教</option><option value="讲师">讲师</option><option value="副教授">副教授</option><option value="教授">教授</option>
    <%
    } else if ("助教".equals(request.getAttribute("title"))){
    %>
    <option value="">全部</option><option value="助教" selected>助教</option><option value="讲师">讲师</option><option value="副教授">副教授</option><option value="教授">教授</option>
    <%
    } else if("讲师".equals(request.getAttribute("title"))){
    %>
    <option value="">全部</option><option value="助教">助教</option><option value="讲师" selected>讲师</option><option value="副教授">副教授</option><option value="教授">教授</option>
    <%
    } else if ("副教授".equals(request.getAttribute("title"))){
    %>
    <option value="">全部</option><option value="助教">助教</option><option value="讲师">讲师</option><option value="副教授" selected>副教授</option><option value="教授">教授</option>
    <%
    } else if ("教授".equals(request.getAttribute("title"))){
    %>
    <option value="">全部</option><option value="助教">助教</option><option value="讲师">讲师</option><option value="副教授">副教授</option><option value="教授" selected>教授</option>
    <%
        }
    %>
</select>&nbsp;&nbsp;
    授课课程编号：<input type="text" name="course" value="<%=request.getAttribute("course")==null?"":request.getAttribute("course")%>"><br>
    <input type="submit" value="查看"><br>
<a href="selectTeacher.action?insert=1">添加教师信息</a>
<br><a href="begin.action">返回首页</a>
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
<input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
<h2><button style="font-size: 20px;text-align: center;" onclick="up(<%=(Integer)request.getAttribute("page")-1%>)" class="button">上一页</button>
    &nbsp;&nbsp;<%=request.getAttribute("page")%>/<%=request.getAttribute("total")%>&nbsp;&nbsp;
    <button style="font-size: 20px;text-align: center;" onclick="up(<%=(Integer)request.getAttribute("page")+1%>)" class="button">下一页</button>
</form>
</body>
</html>