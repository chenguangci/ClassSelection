<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加学生信息</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr="<tr><td><input type=\"text\" name=\"studentNo\"></td>"+
                    "<td><input type=\"text\" name=\"studentName\"></td>"+
                    "<td><select name=\"studentSex\"><option value=\"男\">男</option><option value=\"女\" >女</option></select></td>"+
                    "<td><input type=\"text\" name=\"studentAge\"></td>"+
                    "<td><input type=\"text\" name=\"departmentNo\"></td>"+
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
            <td>系编号</td>
        </tr>
        <tr>
            <td><input type="text" name="studentNo"></td>
            <td><input type="text" name="studentName"></td>
            <td><select name="studentSex"><option value="男">男</option><option value="女" >女</option></select></td>
            <td><input type="text" name="studentAge"></td>
            <td><input type="text" name="departmentNo"></td>
        </tr>
    </table>
    <input type="button" value="增加" id="addTable"/><br>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
