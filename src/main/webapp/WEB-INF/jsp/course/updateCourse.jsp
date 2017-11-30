<%@ page import="com.cgc.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>更新课程信息</title>
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
<div class="left"><a href="selectCourse.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div class="show">
    <%
        Course course = ((List<Course>)request.getAttribute("courses")).get(0);
    %>
    <form action="updateCourse.action" method="post" id="form1">
        <h1>
        <input type="hidden" name="courseNo" value="<%=course.getCourseNo()%>">
        课程号：<%=course.getCourseNo()%><br>
        课程名称：<input type="text" name="courseName" class="basic-slide" value="<%=course.getCourseName()%>"><br>
        先修课程号：<input type="text" name="coursePriorNo" class="basic-slide" value="<%=course.getCoursePriorNo()==null?"":course.getCoursePriorNo()%>"><br>
        课程学分：<input type="text" name="courseCredit" class="basic-slide" value="<%=course.getCourseCredit()%>"><br>
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
                url: '/updateCourse.action',
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
