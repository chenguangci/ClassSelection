<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>课程信息</title>
    <link href="${path}/resource/css/style.css" type="text/css" rel="stylesheet">
    <link href="${path}/resource/css/layui.css" type="text/css" rel="stylesheet">
    <script src="${path}/resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page) {
            $("#page").val(page);
            $("#show").submit();
        }
        function sub() {
            $("#show").submit();
        }

    </script>
</head>
<body>
<div class="left" style="margin-top: 30px"><a href="begin.action"><img src="${path}/resource/image/return.png" width="110" height="46"></a></div>
<div>
    <form id="show" method="post" action="selectCourse.action">
        <h1>
            课程编号：<input type="text" class="basic-slide" name="courseNo"
                        value="<%=request.getAttribute("courseNo")==null?"":request.getAttribute("courseNo")%>">&nbsp;&nbsp;
            课程名称：<input type="text" class="basic-slide" name="courseName"
                        value="<%=request.getAttribute("courseName")==null?"":request.getAttribute("courseName")%>"><br>
            先修课程号：<input type="text" class="basic-slide" name="coursePriorNo"
                         value="<%=request.getAttribute("coursePriorNo")==null?"":request.getAttribute("coursePriorNo")%>">&nbsp;&nbsp;
            课程学分：<input type="text" class="basic-slide" name="courseCredit"
                        value="<%=request.getAttribute("courseCredit")==null?"":request.getAttribute("courseCredit")%>"><br>
            <button onclick="sub()"
                    style="background: url(/resource/image/search.png);width: 113px;height: 40px;border: 0;">
            </button><br>
        </h1>
        <h2><input type="hidden"></h2>
        <h2 class="left_top"><a href="selectCourse.action?insert=1"><img src="${path}/resource/image/course.png" width="120" height="40" style="text-align: left"></a></h2>
        <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th>序号</th>
                <th>课程号</th>
                <th>课程名称</th>
                <th>先修课程名</th>
                <th>课程学分</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Course> courses = (List<Course>) request.getAttribute("courses");
                for (int i = 0; i < courses.size(); i++) {
                    out.print("<tr id=\"tr"+i+"\">");
                    out.print("<td>" + (i + 1) + "</td>");
                    out.print("<td>" + courses.get(i).getCourseNo() + "</td>");
                    out.print("<td>" + courses.get(i).getCourseName() + "</td>");
                    if (courses.get(i).getCoursePriorName() == null)
                        out.print("<td></td>");
                    else
                        out.print("<td>" + courses.get(i).getCoursePriorName() + "</td>");
                    out.print("<td>" + courses.get(i).getCourseCredit() + "</td>");
            %>
            <td>
                <a href="javascript:" onclick="deleteById('<%=courses.get(i).getCourseNo()%>','<%=courses.get(i).getCourseName()%>','<%=i%>')">删除</a>&nbsp;&nbsp;
                <a href="${path}/selectCourse.action?courseNo=<%=courses.get(i).getCourseNo()%>&update=1">修改</a>
                <input type="hidden" value="<%=courses.get(i).getCoursePriorNo()%>">
            </td>
            <%
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
        <input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
        <h1>
            <button onclick="up(<%=(Integer)request.getAttribute("page")-1%>)"
                    style="background: url(/resource/image/up.png);width: 75px;height: 40px;border: 0">
            </button>
            &nbsp;&nbsp;<%=request.getAttribute("page")%>/<%=request.getAttribute("total")%>&nbsp;&nbsp;
            <button onclick="up(<%=(Integer)request.getAttribute("page")+1%>)"
                    style="background: url(/resource/image/down.png);width: 75px;height: 40px;border: 0">
            </button>
        </h1>
    </form>
    <form method="post" action="download.action?type=course" id="show2">
        <input type="hidden" name="courseNo" value="<%=request.getAttribute("courseNo")%>">
        <input type="hidden" name="courseName" value="<%=request.getAttribute("courseName")%>">
        <input type="hidden" name="coursePriorNo" value="<%=request.getAttribute("coursePriorNo")%>">
        <input type="hidden" name="courseCredit" value="<%=request.getAttribute("courseCredit")%>">
        <button onclick="sub2()"
                style="background: url(/resource/image/table.png);border: 0;width: 160px;height: 40px">
        </button>
    </form>
</div>
<script>
    function deleteById(id, label,i) {
        var r = confirm('确定要删除"'+label+'"吗？');
        if (r) {
            $.ajax({
                url: '${path}/deleteCourse.action?courseNo='+id,
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
    function sub2() {
        var a = $.ajax({
            url: '${path}/download.action?type=course',
            dataType:'json',
            timeout : 1000,
            type:'POST',
            success:function (data) {
                $.ajax({
                    url: '/selectCourse.action',
                    type:'POST'
                });
                alert(data.msg);
            }
        });
    }
</script>
</body>
</html>
