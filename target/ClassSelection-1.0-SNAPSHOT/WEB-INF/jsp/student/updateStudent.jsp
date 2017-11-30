<%@ page import="com.cgc.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>更新学生信息</title>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${path}/resource/js/jquery-1.8.0.min.js"></script>
    <style type="text/css">
        body .show{
            background-color:rgba(255,255,255,0.8);
            margin: 20px;
            padding: 100px;
        }
    </style>
</head>
<body>
<div class="left"><a href="selectStudent.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div class="show">
    <%
        Student student = ((List<Student>) request.getAttribute("students")).get(0);
    %>
    <form action="updateStudent.action" method="post" id="form1">
        <h1>
        <input type="hidden" name="studentNo" value="<%=student.getStudentNo()%>">
        学号：<%=student.getStudentNo()%><br>
        姓名：<input type="text" name="name" class="basic-slide" value="<%=student.getStudentName()%>"><br>
        性别：<select name="sex" id="sex">
        <%
            if ("男".equals(student.getStudentSex())) {
        %>
        <option value="男" selected>男</option><option value="女">女</option>
        <%
            } else {

        %>
        <option value="男">男</option><option value="女" selected>女</option>
        <%
            }
        %>
        </select><br>
        年龄：<input type="text" name="age" class="basic-slide" value="<%=student.getStudentAge()%>"><br>
        系编号：
        <%
            Map<String,String> department = (Map<String, String>) request.getAttribute("department");
        %>
        <select name="departmentNo" class="styled-select">
            <%
                for (Map.Entry entry:department.entrySet()) {
                    if (student.getDepartmentNo().equals(entry.getKey())){
            %>
                    <option value="<%=entry.getKey()%>" selected><%=entry.getValue()%></option>
            <%
                    }else{
            %>
                    <option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
            <%
                }
            }
            %>
        </select><br>
            <input type="button" onclick="sub()" value="" style="background: url(${path}/resource/image/submit.png);width: 95px;height: 40px;border: 0">
        </h1>
    </form>
</div>
<script>
    function sub() {
        var r = confirm('确定要提交数据吗');
        if (r) {
            var datas = $('#form1').serialize();
            $.ajax({
                type: 'POST',
                url: '/updateStudent.action',
                dataType: 'json',
                data:datas,
                success: function (data) {
                    alert(data.msg);
                }
            });
        }
    }
</script>
</body>
</html>
