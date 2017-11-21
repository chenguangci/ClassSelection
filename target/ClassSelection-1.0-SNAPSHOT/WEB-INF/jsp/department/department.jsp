<%@ page import="com.cgc.bean.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>院系信息</title>
    <script src="resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page) {
            $("#page").val(page);
            $("#show").submit();
        }
    </script>
</head>
<body>
<form id="show" method="post" action="selectDepartment.action">
    院系编号：<input type="text" name="departmentNo"
                value="<%=request.getAttribute("departmentNo")==null?"":request.getAttribute("departmentNo")%>">&nbsp;&nbsp;
    院系名称：<input type="text" name="departmentName"
                value="<%=request.getAttribute("departmentName")==null?"":request.getAttribute("departmentName")%>">&nbsp;&nbsp;
    院系主任名：<input type="text" name="manager"
                 value="<%=request.getAttribute("manager")==null?"":request.getAttribute("manager")%>"><br>
    <input type="submit" value="查看"><br>
<a href="selectDepartment.action?insert=1">添加院系信息</a>
<br><a href="begin.action">返回首页</a>
    <input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
    <table border="1px">
        <tr>
            <td>序号</td>
            <td>院系编号</td>
            <td>院系名称</td>
            <td>院系主任名</td>
            <td>操作</td>
        </tr>
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
    </table>
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
