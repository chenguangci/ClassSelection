<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Map<String,String> department = (Map<String, String>) request.getAttribute("department");
    StringBuilder value= new StringBuilder();
    StringBuilder value2 = new StringBuilder();
    for (Map.Entry entry:department.entrySet()) {
        value.append("<option value=\"").append(entry.getKey()).append("\">").append(entry.getValue()).append("</option>");
        value2.append("<option value=\\\"").append(entry.getKey()).append("\\\">").append(entry.getValue()).append("</option>");
    }
%>
<html>
<head>
    <title>添加学生信息</title>
    <script type="text/javascript" src="/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr1 = "<%=value2%>";
                var tr="<tr><td><input type=\"text\" name=\"studentNo\"></td>"+
                    "<td><input type=\"text\" name=\"studentName\"></td>"+
                    "<td><select name=\"studentSex\"><option value=\"男\">男</option><option value=\"女\" >女</option></select></td>"+
                    "<td><input type=\"text\" name=\"studentAge\"></td>"+
                    "<td><select name=\"departmentNo\">"+tr1+"</select></td>"+
                    "</tr>";
                $("#table1").append(tr);
            });
        })
    </script>
    <%
        if (request.getParameter("error")!=null){
            out.print("<script type=\"text/javascript\">function a(){alert(\"执行操作失败，请查看输入数据是否合法\");} a();</script>");
        }
    %>
</head>
<body>
<a href="selectStudent.action">返回</a>
<form method="post" action="insertStudent.action">
    <table id="table1">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>院系</td>
        </tr>
        <tr>
            <td><input type="text" name="studentNo"></td>
            <td><input type="text" name="studentName"></td>
            <td><select name="studentSex"><option value="男">男</option><option value="女" >女</option></select></td>
            <td><input type="text" name="studentAge"></td>
            <td>
                <select name="departmentNo">
                <%=value%>
                </select>
            </td>
        </tr>
    </table>
    <input type="button" value="增加" id="addTable"/><br>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
