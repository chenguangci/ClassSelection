<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加选课信息</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr="<tr><td><input type=\"text\" name=\"studentNo\"></td>"+
                    "<td><input type=\"text\" name=\"courseNo\"></td>"+
                    "<td><input type=\"text\" name=\"teacherNo\"></td>"+
                    "<td><input type=\"text\" name=\"grade\"></td>"+
                    "</tr>";
                $("#table1").append(tr);
            });
        })
    </script>
</head>
<body>
<a href="selectSelectCourse.action">返回</a>
<form method="post" action="insertSelectCourse.action">
    <table id="table1">
        <tr>
            <td>学号</td>
            <td>课程号</td>
            <td>教师编号</td>
            <td>成绩</td>
        </tr>
        <tr>
            <td><input type="text" name="studentNo"></td>
            <td><input type="text" name="courseNo"></td>
            <td><input type="text" name="teacherNo"></td>
            <td><input type="text" name="grade"></td>
        </tr>
    </table>
    <input type="button" value="增加" id="addTable"/><br>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
