<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>添加教师信息</title>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${path}/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#addTable").click(function () {
                var tr = "<tr><td><input type=\"text\" class=\"basic-slide\" name=\"teacherNo\"></td>" +
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"teacherName\"></td>" +
                    "<td><select name=\"teacherSex\" class=\"styled-select\"><option value=\"男\">男</option><option value=\"女\" >女</option></select></td>" +
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"teacherAge\"></td>" +
                    "<td><select name=\"education\" class=\"styled-select\"><option value=\"学士\">学士</option><option value=\"硕士\">硕士</option><option value=\"博士\">博士</option></select></td>" +
                    "<td><select name=\"title\" class=\"styled-select\"><option name=\"助教\">助教</option><option name=\"讲师\">讲师</option><option name=\"副教授\">副教授</option><option name=\"教授\">教授</option></select></td>" +
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"courseNo1\"></td>" +
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"courseNo2\"></td>" +
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"courseNo3\"></td>" +
                    "<td><input type=\"button\" class=\"basic-slide\" value=\"移除\" onclick=\"deleteRow(this)\"></td>" +
                    "</tr>";
                $("#keywords").append(tr);
            });

        });

        function deleteRow(r) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById('keywords').deleteRow(i);
        }
    </script>
    <%
        if (request.getParameter("error") != null) {
            out.print("<script type=\"text/javascript\">function a(){alert(\"执行操作失败，请查看输入数据是否合法\");} a();</script>");
        }
    %>
</head>
<body>
<div class="left"><a href="selectTeacher.action"><img src="${path}/resource/image/return.png" width="110"
                                                      height="45"></a></div>
<div>
    <form id="form1" enctype="multipart/form-data" method="post" action="insertTeacher.action">
        <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th>教师编号</th>
                <th>教师姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>学历</th>
                <th>职称</th>
                <th>所授课程1</th>
                <th>所授课程2</th>
                <th>所授课程3</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" class="basic-slide" name="teacherNo"></td>
                <td><input type="text" class="basic-slide" name="teacherName"></td>
                <td><select name="teacherSex" class="styled-select">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select></td>
                <td><input type="text" class="basic-slide" name="teacherAge"></td>
                <td><select name="education" class="styled-select">
                    <option value="学士">学士</option>
                    <option value="硕士">硕士</option>
                    <option value="博士">博士</option>
                </select></td>
                <td><select name="title" class="styled-select">
                    <option name="助教">助教</option>
                    <option name="讲师">讲师</option>
                    <option name="副教授">副教授</option>
                    <option name="教授">教授</option>
                </select></td>
                <td><input type="text" class="basic-slide" name="courseNo1"></td>
                <td><input type="text" class="basic-slide" name="courseNo2"></td>
                <td><input type="text" class="basic-slide" name="courseNo3"></td>
                <td><input type="button" class="basic-slide" value="移除" onclick="deleteRow(this)"></td>
            </tr>
            </tbody>
        </table>
        <h1>
            <input type="button" value="" id="addTable"
                   style="background: url(${path}/resource/image/add_row.png);width: 95px;height: 40px;border: 0"/>&nbsp;&nbsp;
            <input type="button" onclick="sub()" value=""
                   style="background: url(${path}/resource/image/submit.png);width: 95px;height: 40px;border: 0">
        </h1>
    </form>
</div>
<script>
    function sub() {
        var r = confirm('确定要提交数据吗');
        if (r) {
            var datas = $('#form1').serializeArray();
            $.ajax({
                type: 'POST',
                url: '/insertTeacher.action',
                dataType: 'json',
                data:datas,
                success: function (data) {
                    if (data.success) {
                        alert(data.msg);
                    } else {
                        var array = (data.array.substring(1,data.array.length-1)).split(",");
                        for (var i=1;i<=array.length;i++) {
                            if (array[i-1] === "1") {
                                document.getElementById('keywords').deleteRow(i);
                            }
                        }
                        alert(data.msg);
                    }
                }
            });
        }
    }
</script>
</body>
</html>
