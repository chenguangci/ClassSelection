<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户信息</title>
    <link href="${path}/resource/css/style.css" type="text/css" rel="stylesheet">
    <link href="${path}/resource/css/layui.css" type="text/css" rel="stylesheet">
    <script src="${path}/resource/js/jquery-1.8.0.min.js"></script>
</head>
<body>
<div class="left" style="margin-top: 30px"><a href="begin.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div>
    <form id="show" method="post" action="selectUser.action">
        <h1>
            用户名：<input type="text" class="basic-slide" name="username"
                        value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>">&nbsp;&nbsp;
            权限级别：<select name="role" id="sex">
            <%
            if ("3".equals(request.getAttribute("role"))) {
            %>
            <option value="0">全部</option><option value="3" selected>级别三</option><option value="4">级别四</option>
            <%
            } else if ("4".equals(request.getAttribute("role"))) {
            %>
            <option value="">全部</option><option value="3">级别三</option><option value="4" selected>级别四</option>
            <%
            } else {
            %>
            <option value="0" selected>全部</option><option value="3">级别三</option><option value="4">级别四</option>
            <%
                }
            %>
        </select><br>
            <button onclick="sub()"
                    style="background: url(/resource/image/search.png);width: 113px;height: 40px;border: 0;">
            </button><br>
        </h1>
        <h2><input type="hidden"></h2>
        <h2 class="left_top"><a href="selectUser.action?insert=1"><img src="${path}/resource/image/user.png" width="120" height="40" style="text-align: left"></a></h2>
        <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>权限级别</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                for (int i = 0; i < users.size(); i++) {
                    out.print("<tr id=\"tr"+i+"\">");
                    out.print("<td>" + (i + 1) + "</td>");
                    out.print("<td>" + users.get(i).getUsername() + "</td>");
                    out.print("<td>******</td>");
                    out.print("<td>" + users.get(i).getRole() + "</td>");
            %>
            <td>
                <input type="hidden" name="password" id="password">
                <a href="javascript:" onclick="deleteById('<%=users.get(i).getUsername()%>','<%=i%>')">删除</a>&nbsp;&nbsp;
                <a href="${path}/selectUser.action?username=<%=users.get(i).getUsername()%>&role=<%=users.get(i).getRole()%>&update=1">修改</a>
            </td>
            <%
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
    </form>
</div>
<script>
    function sub() {
        $("#show").submit();
    }
    function deleteById(id,i) {
        var r = confirm('确定要删除"'+id+'"吗？');
        if (r) {
            var password=prompt("请输入"+id+"的密码","");
            $.ajax({
                url: '${path}/deleteUser.action?username='+id+'&password='+password,
                dataType:'json',
                type:'POST',
                success:function (data) {
                    if (data.success) {
                        alert('成功');
                        $('#tr'+i).remove();
                    } else {
                        alert(data.msg);
                    }
                }
            });
        }
    }
</script>
</body>
</html>
