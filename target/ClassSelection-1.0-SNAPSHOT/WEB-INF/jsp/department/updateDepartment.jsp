<%@ page import="com.cgc.bean.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>更新院系信息</title>
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
<div class="left"><a href="selectDepartment.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div class="show">
<%
    Department department = ((List<Department>)request.getAttribute("departments")).get(0);
%>
<form action="updateDepartment.action" method="post" id="form1">
    <h1>
    <input type="hidden" name="departmentNo" value="<%=department.getDepartmentNo()%>">
    院系编号：<%=department.getDepartmentNo()%><br>
    院系名称：<input type="text" name="departmentName" class="basic-slide" value="<%=department.getDepartmentName()%>"><br>
    院系主任：<input type="text" name="manager" class="basic-slide" value="<%=department.getManager()%>"><br>
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
                url: '/updateDepartment.action',
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
