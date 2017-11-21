<%--
  Created by IntelliJ IDEA.
  User: BeiYi
  Date: 2017/11/19
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加课程信息</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr="<tr><td><input type=\"text\" name=\"courseNo\"></td>"+
                    "<td><input type=\"text\" name=\"courseName\"></td>"+
                    "<td><input type=\"text\" name=\"coursePriorNo\"></td>"+
                    "<td><input type=\"text\" name=\"courseCredit\"></td>"+
                    "</tr>";
                $("#table1").append(tr);
            });
        });
        function getError() {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
                document.getElementById("error").innerHTML=xmlHttp.responseText;
            }
        }
    </script>
    <%
        if (request.getParameter("error")!=null){
            out.print("<script type=\"text/javascript\">function a(){alert(\"执行操作失败，请查看输入数据是否合法\");} a();</script>");
        }
    %>
</head>
<body>
<a href="selectCourse.action">返回</a>
<form method="post" action="insertCourse.action">
    <table id="table1">
        <tr>
            <td>课程号</td>
            <td>课程名称</td>
            <td>先修课程</td>
            <td>课程学分</td>
        </tr>
        <tr>
            <td><input type="text" name="courseNo"></td>
            <td><input type="text" name="courseName"></td>
            <td><input type="text" name="coursePriorNo"></td>
            <td><input type="text" name="courseCredit"></td>
        </tr>
    </table>
    <div id="error" style="color: red"><h3></h3></div>
    <input type="button" value="增加" id="addTable"/><br>
    <input type="submit" value="提交" onclick="getError()">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
