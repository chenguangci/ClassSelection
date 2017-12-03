<%@ page import="java.util.List" %>
<%@ page import="com.cgc.bean.SelectCourse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>选课信息</title>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <link href="${path}/resource/css/layui.css" type="text/css" rel="stylesheet">
    <script src="${path}/resource/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function up(page) {
            $("#page").val(page);
            $("#show").submit();
        }

        function sub2() {
            $("#show2").submit();
        }
    </script>
</head>
<body>
<div class="left" style="margin-top: 30px"><a href="begin.action"><img src="${path}/resource/image/return.png" width="110" height="45"></a></div>
<div>
    <form method="post" action="selectSelectCourse.action">
        <h1>
            学号：<input type="text" class="basic-slide" name="studentNo"
                      value="<%=request.getAttribute("studentNo")==null?"":request.getAttribute("studentNo")%>">&nbsp;&nbsp;
            课程号：<input type="text" class="basic-slide" name="courseNo"
                       value="<%=request.getAttribute("courseNo")==null?"":request.getAttribute("courseNo")%>">&nbsp;&nbsp;
            教师编号：<input type="text" class="basic-slide" name="teacherNo"
                        value="<%=request.getAttribute("teacherNo")==null?"":request.getAttribute("teacherNo")%>"><br>
            <%--成绩：<input type="text" name="grade"><br>--%>
            <button onclick="sub()"
                    style="background: url(/resource/image/search.png);width: 113px;height: 40px;border: 0;">
            </button>
            <br>
            <h2><input type="hidden"></h2>
            <h2 class="left_top"><a href="selectSelectCourse.action?insert=1"><img src="${path}/resource/image/select.png"
                                                                                   width="120" height="40"
                                                                                   style="text-align: left"></a></h2>
        </h1>
        <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th>序号</th>
                <th>课程号</th>
                <th>课程名</th>
                <th>学号</th>
                <th>学生姓名</th>
                <th>教师编号</th>
                <th>教师姓名</th>
                <th>成绩</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<SelectCourse> selectCourses = (List<SelectCourse>) request.getAttribute("selects");
                for (int i = 0; i < selectCourses.size(); i++) {
                    out.print("<tr id=\"tr"+i+"\">");
                    out.print("<td>" + (i + 1) + "</td>");
                    out.print("<td>" + selectCourses.get(i).getCourseNo() + "</td>");
                    out.print("<td>" + selectCourses.get(i).getCourseName() + "</td>");
                    out.print("<td>" + selectCourses.get(i).getStudentNo() + "</td>");
                    out.print("<td>" + selectCourses.get(i).getStudentName() + "</td>");
                    out.print("<td>" + selectCourses.get(i).getTeacherNo() + "</td>");
                    out.print("<td>" + selectCourses.get(i).getTeacherName() + "</td>");
                    if (selectCourses.get(i).getGrade()==null) {
                        out.print("<td></td>");
                    } else {
                        out.print("<td>" + selectCourses.get(i).getGrade() + "</td>");
                    }
            %>
            <td>
                <a href="javascript:" onclick="deleteById('<%=selectCourses.get(i).getCourseNo()%>','<%=selectCourses.get(i).getStudentNo()%>','<%=selectCourses.get(i).getTeacherNo()%>','<%=i%>')">删除</a>&nbsp;&nbsp;
                <a href="${path}/selectSelectCourse.action?studentNo=<%=selectCourses.get(i).getStudentNo()%>&courseNo=<%=selectCourses.get(i).getCourseNo()%>&teacherNo=<%=selectCourses.get(i).getTeacherNo()%>&update=1">修改</a>
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
    <form method="post" action="download.action?type=select" id="show2">
        <input type="hidden" name="studentNo" value="<%=request.getAttribute("studentNo")%>">
        <input type="hidden" name="courseNo" value="<%=request.getAttribute("courseNo")%>">
        <input type="hidden" name="teacherNo" value="<%=request.getAttribute("teacherNo")%>">
        <button onclick="sub2()"
                style="background: url(/resource/image/table.png);border: 0;width: 160px;height: 40px">
        </button>
    </form>
</div>
<script>
    function deleteById(c,s,t,i) {
        var r = confirm('确定要删除吗？');
        if (r) {
            $.ajax({
                url: '${path}/deleteSelectCourse.action?courseNo='+c+'&studentNo='+s+'&teacherNo='+t,
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
