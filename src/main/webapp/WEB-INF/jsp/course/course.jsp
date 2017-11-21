<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
    <script src="resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page){
            $("#page").val(page);
            $("#show").submit();
        }
    </script>
</head>
<body>
<form id="show" method="post" action="selectCourse.action">
    课程编号：<input type="text" name="courseNo" value="<%=request.getAttribute("courseNo")==null?"":request.getAttribute("courseNo")%>">&nbsp;&nbsp;
    课程名称：<input type="text" name="courseName" value="<%=request.getAttribute("courseName")==null?"":request.getAttribute("courseName")%>"><br>
    先修课程号：<input type="text" name="coursePriorNo" value="<%=request.getAttribute("coursePriorNo")==null?"":request.getAttribute("coursePriorNo")%>">&nbsp;&nbsp;
    课程学分：<input type="text" name="courseCredit" value="<%=request.getAttribute("courseCredit")==null?"":request.getAttribute("courseCredit")%>"><br>
    <input type="submit" value="查看"><br>
<a href="selectCourse.action?insert=1">添加课程信息</a><br>
<a href="begin.action">返回首页</a>
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
    <input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
    <h2><button style="font-size: 20px;text-align: center;" onclick="up(<%=(Integer)request.getAttribute("page")-1%>)" class="button">上一页</button>
        &nbsp;&nbsp;<%=request.getAttribute("page")%>/<%=request.getAttribute("total")%>&nbsp;&nbsp;
        <button style="font-size: 20px;text-align: center;" onclick="up(<%=(Integer)request.getAttribute("page")+1%>)" class="button">下一页</button>
</form>
</body>
</html>
