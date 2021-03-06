<%@ page import="com.cgc.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>修改用户信息</title>
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
<div class="left"><a href="selectUser.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div class="show">
    <%
        User user = ((List<User>)request.getAttribute("users")).get(0);
        String role = (String) request.getAttribute("role");
    %>
    <form action="updateUser.action" method="post" id="form1">
        <h1>
            <input type="hidden" name="username" value="<%=user.getUsername()%>">
            用户名：<%=user.getUsername()%><br>
            旧密码：<input type="password" name="oldPassword" class="basic-slide"><br>
            新密码：<input type="password" name="newPassword" class="basic-slide"><br>
            确认密码：<input type="password" name="confirm" class="basic-slide"><br>
            用户权限：<select name="role" id="sex">
            <%
                if ("2".equals(role)) {
            %>
            <option value="2" selected>级别二</option><option value="3">级别三</option><option value="4">级别四</option>
            <%
                } else if ("3".equals(role)) {
            %>
            <option value="2">级别二</option><option value="3" selected>级别三</option><option value="4">级别四</option>
            <%
                } else if ("4".equals(role)) {
            %>
            <option value="2">级别二</option><option value="3">级别三</option><option value="4" selected>级别四</option>
            <%
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
                url: '/updateUser.action',
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
