<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.SelectCourse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>更新选课信息</title>
    <script type="text/javascript" src="${path}/resource/js/jquery-1.8.0.min.js"></script>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <style type="text/css">
        body .show{
            background-color:rgba(255,255,255,0.8);
            margin: 20px;
            padding: 100px;
        }
    </style>
</head>
<body>
<div class="left"><a href="selectSelectCourse.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div class="show">
<%
    SelectCourse selectCourse = ((List<SelectCourse>)request.getAttribute("selects")).get(0);
%>
<form action="updateSelectCourse.action" method="post" id="form1">
    <h1>
        <input type="hidden" name="id" value="<%=selectCourse.getStudentNo()+selectCourse.getCourseNo()+selectCourse.getTeacherNo()%>">
    学号：<input type="text" name="studentNo" class="basic-slide" value="<%=selectCourse.getStudentNo()%>"><br>
    课程号：<input type="text" name="courseNo" class="basic-slide" value="<%=selectCourse.getCourseNo()%>"><br>
    教师号：<input type="text" name="teacherNo" class="basic-slide" value="<%=selectCourse.getTeacherNo()%>"><br>
    成绩：<input type="text" name="grade" class="basic-slide" value="<%=selectCourse.getGrade()==null?"":selectCourse.getGrade()%>"><br>
        <input type="button" onclick="sub()" value="" style="background: url(${path}/resource/image/submit.png);width: 95px;height: 40px;border: 0">
    </h1>
</form>
</div>
<script>
    function sub() {
        var r = confirm('确定要提交数据吗');
        if (r) {
            var data = $('#form1').serialize();
            $.ajax({
                type: 'POST',
                url: '/updateSelectCourse.action',
                dataType: 'json',
                data:data,
                success: function (data) {
                    alert(data.msg);
                }
            });
        }
    }
</script>
</body>
</html>