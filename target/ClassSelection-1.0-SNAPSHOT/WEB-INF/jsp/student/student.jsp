<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
    <script src="resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page) {
            $("#page").val(page);
            $("#show").submit();
        }
    </script>
</head>
<body>
<form id="show" method="post" action="selectStudent.action">
    学号：<input type="text" name="studentNo"
              value="<%=request.getAttribute("studentNo")==null?"":request.getAttribute("studentNo")%>">&nbsp;&nbsp;
    姓名：<input type="text" name="name" value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>">&nbsp;&nbsp;
    <%
        if (request.getAttribute("sex") == null || "".equals(request.getAttribute("sex"))) {
    %>
    性别：<select name="sex">
    <option value="" selected>全部</option>
    <option value="男">男</option>
    <option value="女">女</option>
</select><br>
    <%
    } else if ("男".equals(request.getAttribute("sex"))) {
    %>
    性别：<select name="sex">
    <option value="">全部</option>
    <option value="男" selected>男</option>
    <option value="女">女</option>
</select><br>
    <%
    } else if ("女".equals(request.getAttribute("sex"))) {
    %>
    性别：<select name="sex">
    <option value="">全部</option>
    <option value="男">男</option>
    <option value="女" selected>女</option>
</select><br>
    <%
        }
    %>
    年龄：<input type="text" name="age" value="<%=request.getAttribute("age")==null?"":request.getAttribute("age")%>">&nbsp;&nbsp;
    系编号：<input type="text" name="departmentNo"
               value="<%=request.getAttribute("departmentNo")==null?"":request.getAttribute("departmentNo")%>"><br>
    <input type="submit" value="查看"><br>

    <a href="selectStudent.action?insert=1">添加学生信息</a>
    <br><a href="begin.action">返回首页</a>
    <table border="1px">
        <tr>
            <td>序号</td>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>系编号</td>
            <td>操作</td>
        </tr>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (int i = 0; i < students.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + (i + 1) + "</td>");
                out.print("<td>" + students.get(i).getStudentNo() + "</td>");
                out.print("<td>" + students.get(i).getStudentName() + "</td>");
                out.print("<td>" + students.get(i).getStudentSex() + "</td>");
                out.print("<td>" + students.get(i).getStudentAge() + "</td>");
                out.print("<td>" + students.get(i).getDepartmentNo() + "</td>");
        %>
        <td>
            <a href="<%=request.getContextPath()%>/deleteStudent.action?studentNo=<%=students.get(i).getStudentNo()%>">删除</a>&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/selectStudent.action?studentNo=<%=students.get(i).getStudentNo()%>&update=1">修改</a>
        </td>
        <%
                out.print("</tr>");
            }
        %>
    </table>
    <input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
    <h2>
        <button style="font-size: 20px;text-align: center;" onclick="up(<%=(Integer)request.getAttribute("page")-1%>)"
                class="button">上一页
        </button>
        &nbsp;&nbsp;<%=request.getAttribute("page")%>/<%=request.getAttribute("total")%>&nbsp;&nbsp;
        <button style="font-size: 20px;text-align: center;" onclick="up(<%=(Integer)request.getAttribute("page")+1%>)"
                class="button">下一页
        </button>
</form>
</body>
</html>