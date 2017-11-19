<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加院系信息</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr="<tr><td><input type=\"text\" name=\"departmentNo\"></td>"+
                    "<td><input type=\"text\" name=\"departmentName\"></td>"+
                    "<td><input type=\"text\" name=\"manager\"></td>"+
                    "</tr>";
                $("#table1").append(tr);
            });
        })
    </script>
</head>
<body>
<form method="post" action="insertDepartment.action">
    <table id="table1">
        <tr>
            <td>院系编号</td>
            <td>院系名称</td>
            <td>院系主任名</td>
        </tr>
        <tr>
            <td><input type="text" name="departmentNo"></td>
            <td><input type="text" name="departmentName"></td>
            <td><input type="text" name="manager"></td>
        </tr>
    </table>
    <input type="button" value="增加" id="addTable"/><br>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
