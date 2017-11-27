<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Student" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
    Map<String, String> department = (Map<String, String>) request.getAttribute("department");
%>
<html>
<head>
    <title>学生信息</title>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <script src="${path}resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page) {
            $("#page").val(page);
            $("#show").submit();
        }
        function sub() {
            $("#show").submit();
        }
        function sub2() {
            $("#show2").submit();
        }
    </script>
</head>
<body>
<div class="left"><a href="begin.action"><img src="resource/image/return.png" width="110" height="45"></a></div>
<div>
<form id="show" method="post" action="selectStudent.action">
    <h1>
        学号：<input type="text" class="basic-slide" name="studentNo"
                  value="<%=request.getAttribute("studentNo")==null?"":request.getAttribute("studentNo")%>">&nbsp;&nbsp;
        姓名：<input type="text" class="basic-slide" name="name"
                  value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>">&nbsp;&nbsp;
        性别：<select name="sex" id="sex">
        <%
            if (request.getAttribute("sex") == null || "".equals(request.getAttribute("sex"))) {
        %>
        <option value="" selected>全部</option>
        <option value="男">男</option>
        <option value="女">女</option>
        <%
        } else if ("男".equals(request.getAttribute("sex"))) {
        %>
        <option value="">全部</option>
        <option value="男" selected>男</option>
        <option value="女">女</option>
        <%
        } else if ("女".equals(request.getAttribute("sex"))) {
        %>
        <option value="">全部</option>
        <option value="男">男</option>
        <option value="女" selected>女</option>
        <%
            }
        %>
    </select>&nbsp;&nbsp;
        年龄：<input type="text" class="basic-slide" name="age"
                  value="<%=request.getAttribute("age")==null?"":request.getAttribute("age")%>">&nbsp;&nbsp;
        院系：
        <select name="departmentNo" class="styled-select">
            <option value="">全部</option>
            <%
                for (Map.Entry entry : department.entrySet()) {
                    if (entry.getKey().equals(request.getAttribute("departmentNo"))) {
            %>
            <option value="<%=entry.getKey()%>" selected><%=entry.getValue()%>
            </option>
            <%
            } else {
            %>
            <option value="<%=entry.getKey()%>"><%=entry.getValue()%>
            </option>
            <%
                    }
                }
            %>
        </select><br>
        <button onclick="sub()"
                style="background: url(/resource/image/search.png);width: 113px;height: 40px;border: 0;">
        </button>
        <br>
        <h2><input type="hidden"></h2>
        <h2 class="left_top"><a href="selectStudent.action?insert=1"><img src="/resource/image/student.png" width="120" height="40" style="text-align: left"></a></h2>
    </h1>
        <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th><span>序号</span></th>
                <th><span>学号</span></th>
                <th><span>姓名</span></th>
                <th><span>性别</span></th>
                <th><span>年龄</span></th>
                <th><span>院系</span></th>
                <th><span>操作</span></th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");
                for (int i = 0; i < students.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + (i + 1) + "</td>");
                    out.print("<td>" + students.get(i).getStudentNo() + "</td>");
                    out.print("<td>" + students.get(i).getStudentName() + "</td>");
                    out.print("<td>" + students.get(i).getStudentSex() + "</td>");
                    out.print("<td>" + students.get(i).getStudentAge() + "</td>");
                    out.print("<td>" + students.get(i).getDepartmentName() + "</td>");
            %>
            <td>
                <input type="hidden" name="departmentNo" value="<%=students.get(i).getDepartmentNo()%>">
                <a href="<%=request.getContextPath()%>/deleteStudent.action?studentNo=<%=students.get(i).getStudentNo()%>">删除</a>&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/selectStudent.action?studentNo=<%=students.get(i).getStudentNo()%>&update=1">修改</a>
            </td>
            <%
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
    <input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
    <h1>
        <button onclick="up(<%=(Integer)request.getAttribute("page")-1%>)"
                style="background: url(/resource/image/up.png);width: 75px;height: 40px;border: 0">
        </button>
        &nbsp;&nbsp;<%=request.getAttribute("page")%>/<%=request.getAttribute("total")%>&nbsp;&nbsp;
        <button onclick="up(<%=(Integer)request.getAttribute("page")+1%>)"
                style="background: url(/resource/image/down.png);width: 75px;height: 40px;border: 0">
        </button>
    </h1>
</form>
<form method="post" action="download.action?type=student" id="show2">
    <input type="hidden" name="studentNo" value="<%=request.getAttribute("studentNo")%>">
    <input type="hidden" name="studentName" value="<%=request.getAttribute("studentName")%>">
    <input type="hidden" name="studentSex" value="<%=request.getAttribute("studentSex")%>">
    <input type="hidden" name="studentAge" value="<%=request.getAttribute("studentAge")%>">
    <input type="hidden" name="departmentNo" value="<%=request.getAttribute("departmentNo")%>">
    <button onclick="sub2()"
            style="background: url(/resource/image/table.png);border: 0;width: 160px;height: 40px">
    </button>
</form>
</div>
</body>
</html>