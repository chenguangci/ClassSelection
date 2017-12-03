<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生选课系统</title>
    <link rel="stylesheet" type="text/css" href="${path}resource/css/first.css">
</head>
<body style="background: url(/resource/image/background.png);background-size: 100%">
<%
    if (request.getAttribute("error")!=null) {
%>
    <script type="text/javascript">
        alert("对不起，您的权限不足，无法查看用户信息")
    </script>
<%
    }
%>
<div style="margin-top: 30px">
    <div style="float: left">
        <a href="login.action?out=1" style="padding-left: 100px;padding-top: 20px"><img src="${path}resource/image/out.png"></a>
    </div>
    <div style="float: right">
        <a href="${path}/help.html" style="padding-right: 100px;padding-top: 20px"><img src="${path}/resource/image/help.png"></a>
    </div>

</div>
 <div class="container">
     <div class="col4">
         <div class="box-fx">
             <a class="btn btn-fx1" href="selectCourse.action">
                 <img src="${path}resource/image/1.png">
             </a>
         </div>
     </div>

     <div class="col4">
         <div class="box-fx">
             <a class="btn btn-fx2" href="selectDepartment.action">
                 <img src="${path}resource/image/2.png">
             </a>
         </div>
     </div>

     <div class="col4">
         <div class="box-fx">
             <a class="btn btn-fx3" href="selectSelectCourse.action">
                 <img src="${path}resource/image/3.png">
             </a>
         </div>
     </div>

     <div class="col4">
         <div class="box-fx">
             <a class="btn btn-fx4" href="selectStudent.action">
                 <img src="${path}resource/image/4.png">
             </a>
         </div>
     </div>

     <div class="col4">
         <div class="box-fx">
             <a class="btn btn-fx5" href="selectTeacher.action">
                 <img src="${path}resource/image/5.png">
             </a>
         </div>
     </div>

     <div class="col4">
         <div class="box-fx">
             <a class="btn btn-fx6" href="selectUser.action">
                 <img src="${path}resource/image/6.png">
             </a>
         </div>
     </div>

 </div>
</body>
</html>
