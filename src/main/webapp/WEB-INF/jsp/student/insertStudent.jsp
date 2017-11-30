<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
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
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${path}/resource/js/jquery-1.8.0.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#addTable").click(function(){
                var tr1 = "<%=value2%>";
                var tr="<tr><td><input type=\"text\" class=\"basic-slide\" name=\"studentNo\"></td>"+
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"studentName\"></td>"+
                    "<td><select name=\"studentSex\" class=\"styled-select\"><option value=\"男\">男</option><option value=\"女\" >女</option></select></td>"+
                    "<td><input type=\"text\" class=\"basic-slide\" name=\"studentAge\"></td>"+
                    "<td><select name=\"departmentNo\" class=\"styled-select\">"+tr1+"</select></td>"+
                    "<td><input type=\"button\" class=\"basic-slide\" value=\"移除\" onclick=\"deleteRow(this)\"></td>"+
                    "</tr>";
                $("#keywords").append(tr);
            });
        });
        function deleteRow(r)
        {
            var i=r.parentNode.parentNode.rowIndex;
            document.getElementById('keywords').deleteRow(i);
        }
    </script>
    <%
        if (request.getParameter("error")!=null){
            out.print("<script type=\"text/javascript\">function a(){alert(\"执行操作失败，请查看输入数据是否合法\");} a();</script>");
        }
    %>
</head>
<body>
<div class="left"><a href="selectStudent.action"><img src="${path}/resource/image/return.png" width="110" height="45"></a></div>
<div>
<form method="post" action="insertStudent.action" id="form1">
    <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>院系</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" class="basic-slide" name="studentNo"></td>
            <td><input type="text" class="basic-slide" name="studentName"></td>
            <td><select name="studentSex" class="styled-select"><option value="男">男</option><option value="女" >女</option></select></td>
            <td><input type="text" class="basic-slide" name="studentAge"></td>
            <td>
                <select name="departmentNo" class="styled-select">
                <%=value%>
                </select>
            </td>
            <td><input type="button" class="basic-slide" value="移除" onclick="deleteRow(this)"></td>
        </tr>
        </tbody>
    </table>
    <h1>
        <input type="button" value="" id="addTable" style="background: url(${path}/resource/image/add_row.png);width: 95px;height: 40px;border: 0"/>&nbsp;&nbsp;
        <input type="button" onclick="sub()" value="" style="background: url(${path}/resource/image/submit.png);width: 95px;height: 40px;border: 0">
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
                url: '/insertStudent.action',
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
