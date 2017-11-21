<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.SelectCourse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课信息</title>
    <script src="resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page){
            $("#page").val(page);
            $("#show").submit();
        }
    </script>
</head>
<body>
<form method="post" action="selectSelectCourse.action">
    学号：<input type="text" name="studentNo" value="<%=request.getAttribute("studentNo")==null?"":request.getAttribute("studentNo")%>">&nbsp;&nbsp;
    课程号：<input type="text" name="courseNo" value="<%=request.getAttribute("courseNo")==null?"":request.getAttribute("courseNo")%>"><br>
    教师编号：<input type="text" name="teacherNo" value="<%=request.getAttribute("teacherNo")==null?"":request.getAttribute("teacherNo")%>">&nbsp;&nbsp;
    <%--成绩：<input type="text" name="grade"><br>--%>
    <input type="submit" value="查看">
</form>
<a href="selectSelectCourse.action?insert=1">添加选课信息</a>
<br><a href="begin.action">返回首页</a>
<form id="show" method="post" action="selectCourse.action">
<table border="1px">
    <tr>
        <td>序号</td>
        <td>学号</td>
        <td>课程号</td>
        <td>教师编号</td>
        <td>成绩</td>
        <td>操作</td>
    </tr>
    <%
        List<SelectCourse> selectCourses = (List<SelectCourse>) request.getAttribute("selects");
        for (int i=0;i<selectCourses.size();i++) {
            out.print("<tr>");
            out.print("<td>" + (i+1) + "</td>");
            out.print("<td>" + selectCourses.get(i).getStudentNo() + "</td>");
            out.print("<td>" + selectCourses.get(i).getCourseNo() + "</td>");
            out.print("<td>" + selectCourses.get(i).getTeacherNo() + "</td>");
            out.print("<td>" + selectCourses.get(i).getGrade() + "</td>");
    %>
    <td>
        <a href="<%=request.getContextPath()%>/deleteSelectCourse.action?studentNo=<%=selectCourses.get(i).getStudentNo()%>&courseNo=<%=selectCourses.get(i).getCourseNo()%>&teacherNo=<%=selectCourses.get(i).getTeacherNo()%>">删除</a>&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/selectSelectCourse.action?studentNo=<%=selectCourses.get(i).getStudentNo()%>&courseNo=<%=selectCourses.get(i).getCourseNo()%>&teacherNo=<%=selectCourses.get(i).getTeacherNo()%>&update=1">修改</a>
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
