<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>更新教师信息</title>
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
<div class="left"><a href="selectTeacher.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div class="show">
<%
    Teacher teacher = ((List<Teacher>) request.getAttribute("teachers")).get(0);
%>
<form action="updateTeacher.action" method="post" id="form1">
    <h1>
    <input type="hidden" name="teacherNo" value="<%=teacher.getTeacherNo()%>">
    教师编号：<%=teacher.getTeacherNo()%><br>
    姓名：<input type="text" name="teacherName" class="basic-slide" value="<%=teacher.getTeacherName()%>"><br>
    性别：<select name="teacherSex" id="sex">
    <%
        if ("男".equals(teacher.getTeacherSex())) {
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
    年龄：<input type="text" name="teacherAge" class="basic-slide" value="<%=teacher.getTeacherAge()%>"><br>
    学历：<select name="education" class="styled-select">
    <%
        if ("学士".equals(teacher.getEducation())) {
    %>
    <option value="学士" selected>学士</option><option value="硕士">硕士</option><option value="博士">博士</option>
    <%
        } else if("博士".equals(teacher.getEducation())){
    %>
    <option value="学士">学士</option><option value="硕士">硕士</option><option value="博士" selected>博士</option>
    <%
        } else if ("硕士".equals(teacher.getEducation())){
    %>
    <option value="学士">学士</option><option value="硕士" selected>硕士</option><option value="博士">博士</option>
    <%
        }
    %>
    </select><br>
    职称：<select name="title" class="styled-select">
    <%
        if ("助教".equals(teacher.getProfessionalTitle())) {
    %>
    <option name="助教" selected>助教</option><option name="讲师">讲师</option><option name="副教授">副教授</option><option name="教授">教授</option>
    <%
    } else if("讲师".equals(teacher.getProfessionalTitle())){
    %>
    <option name="助教">助教</option><option name="讲师" selected>讲师</option><option name="副教授">副教授</option><option name="教授">教授</option>
    <%
    } else if ("副教授".equals(teacher.getProfessionalTitle())){
    %>
    <option name="助教">助教</option><option name="讲师">讲师</option><option name="副教授" selected>副教授</option><option name="教授">教授</option>
    <%
    } else if ("教授".equals(teacher.getProfessionalTitle())){
    %>
    <option name="助教">助教</option><option name="讲师">讲师</option><option name="副教授">副教授</option><option name="教授" selected>教授</option>
    <%
        }
    %>
    </select><br>
    所授课程1：<input type="text" name="course1" class="basic-slide" value="<%=teacher.getCourseNo1()%>"><br>
    所授课程2：<input type="text" name="course2" class="basic-slide" value="<%=teacher.getCourseNo2()%>"><br>
    所授课程3：<input type="text" name="course3" class="basic-slide" value="<%=teacher.getCourseNo3()%>"><br>
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
                url: '/updateTeacher.action',
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
