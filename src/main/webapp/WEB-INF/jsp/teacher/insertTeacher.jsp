<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>添加教师信息</title>
    <script type="text/javascript" src="<%=basePath%>/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr="<td><input type=\"text\" name=\"teacherNo\"></td>"+
                    "<td><input type=\"text\" name=\"teacherName\"></td>"+
                    "<td><select name=\"teacherSex\"><option value=\"男\">男</option><option value=\"女\" >女</option></select></td>"+
                    "<td><input type=\"text\" name=\"teacherAge\"></td>"+
                    "<td><select name=\"education\"><option value=\"学士\">学士</option><option value=\"硕士\">硕士</option><option value=\"博士\">博士</option></select></td>"+
                    "<td><select name=\"title\"><option name=\"助教\">助教</option><option name=\"讲师\">讲师</option><option name=\"副教授\">副教授</option><option name=\"教授\">教授</option></select></td>"+
                    "<td><input type=\"text\" name=\"courseNo1\"></td>"+
                    "<td><input type=\"text\" name=\"courseNo2\"></td>"+
                    "<td><input type=\"text\" name=\"courseNo3\"></td>"+
                    "</tr>";
                $("#table1").append(tr);
            });
        })
    </script>
</head>
<body>
<form method="post" action="insertTeacher.action">
    <table id="table1">
        <tr>
            <td>教师编号</td>
            <td>教师姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>学历</td>
            <td>职称</td>
            <td>所授课程1</td>
            <td>所授课程2</td>
            <td>所授课程3</td>
        </tr>
        <tr>
            <td><input type="text" name="teacherNo"></td>
            <td><input type="text" name="teacherName"></td>
            <td><select name="teacherSex"><option value="男">男</option><option value="女" >女</option></select></td>
            <td><input type="text" name="teacherAge"></td>
            <td><select name="education"><option value="学士">学士</option><option value="硕士">硕士</option><option value="博士">博士</option></select></td>
            <td><select name="title"><option name="助教">助教</option><option name="讲师">讲师</option><option name="副教授">副教授</option><option name="教授">教授</option></select></td>
            <td><input type="text" name="courseNo1"></td>
            <td><input type="text" name="courseNo2"></td>
            <td><input type="text" name="courseNo3"></td>
        </tr>
    </table>
    <input type="button" value="增加" id="addTable"/><br>
    <input type="submit" value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">

</form>
</body>
</html>
