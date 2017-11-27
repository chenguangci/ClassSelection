<%@ page import="com.cgc.bean.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>院系信息</title>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <script src="resource/js/jquery-1.8.0.min.js"></script>
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
<form id="show" method="post" action="selectDepartment.action">
    <h1>
    院系编号：<input type="text" class="basic-slide" name="departmentNo"
                value="<%=request.getAttribute("departmentNo")==null?"":request.getAttribute("departmentNo")%>">&nbsp;&nbsp;
    院系名称：<input type="text" class="basic-slide" name="departmentName"
                value="<%=request.getAttribute("departmentName")==null?"":request.getAttribute("departmentName")%>">&nbsp;&nbsp;
    院系主任名：<input type="text" class="basic-slide" name="manager"
                 value="<%=request.getAttribute("manager")==null?"":request.getAttribute("manager")%>"><br>
    <button onclick="sub()"
            style="background: url(/resource/image/search.png);width: 113px;height: 40px;border: 0;">
    </button><br>
    <h2><input type="hidden"></h2>
    <h2 class="left_top"><a href="selectDepartment.action?insert=1"><img src="/resource/image/department.png" width="120" height="40" style="text-align: left"></a></h2>
    </h1>
    <input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
    <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th>序号</th>
            <th>院系编号</th>
            <th>院系名称</th>
            <th>院系主任名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Department> departments = (List<Department>) request.getAttribute("departments");
            for (int i = 0; i < departments.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + (i + 1) + "</td>");
                out.print("<td>" + departments.get(i).getDepartmentNo() + "</td>");
                out.print("<td>" + departments.get(i).getDepartmentName() + "</td>");
                out.print("<td>" + departments.get(i).getManager() + "</td>");
        %>
        <td>
            <a href="<%=request.getContextPath()%>/deleteDepartment.action?departmentNo=<%=departments.get(i).getDepartmentNo()%>">删除</a>&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/selectDepartment.action?departmentNo=<%=departments.get(i).getDepartmentNo()%>&update=1">修改</a>
        </td>
        <%
                out.print("</tr>");
            }
        %>
        </tbody>
    </table>
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
    <form method="post" action="download.action?type=department" id="show2">
        <input type="hidden" name="departmentNo" value="<%=request.getAttribute("departmentNo")%>">
        <input type="hidden" name="departmentName" value="<%=request.getAttribute("departmentName")%>">
        <input type="hidden" name="manager" value="<%=request.getAttribute("manager")%>">
        <button onclick="sub2()"
                style="background: url(/resource/image/table.png);border: 0;width: 160px;height: 40px">
        </button>
    </form>
</div>
</body>
</html>
