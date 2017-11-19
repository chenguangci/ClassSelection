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
        })
    </script>
</head>
<body>
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
    <input type="button" value="增加" id="addTable"/>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
