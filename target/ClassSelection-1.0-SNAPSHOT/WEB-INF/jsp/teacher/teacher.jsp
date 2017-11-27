<%@ page import="com.cgc.bean.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>教师信息</title>
    <script src="resource/js/jquery-1.8.0.min.js"></script>
    <link href="${path}resource/css/style.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
        function up(page) {
            $("#page").val(page);
            $("#show").submit();
        }

        function sub() {
            $("#show").submit();
        }

        function sub2() {
            $("#show").submit();
        }
    </script>
</head>
<body>
<div class="left"><a href="begin.action"><img src="resource/image/return.png" width="110" height="45"></a></div>
<div>
    <form id="show" method="post" action="selectTeacher.action">
        <h1>
            教师编号：<input type="text"  class="basic-slide" name="teacherNo"
                        value="<%=request.getAttribute("teacherNo")==null?"":request.getAttribute("teacherNo")%>">&nbsp;&nbsp;
            教师姓名：<input type="text"  class="basic-slide" name="teacherName"
                        value="<%=request.getAttribute("teacherName")==null?"":request.getAttribute("teacherName")%>">&nbsp;&nbsp;
            年龄：<input type="text"  class="basic-slide" name="teacherAge"
                      value="<%=request.getAttribute("teacherAge")==null?"":request.getAttribute("teacherAge")%>"><br>
            性别：<select name="teacherSex" id="sex">
            <%
                if (request.getAttribute("sex") == null || "".equals(request.getAttribute("sex"))) {
            %>
            <option value="" selected>全部</option>
            <option value="男">男</option>
            <option value="女">女</option>
            <%
            } else if ("男".equals(request.getAttribute("sex"))) {
            %>
            <option value="">全部</option>
            <option value="男" selected>男</option>
            <option value="女">女</option>
            <%
            } else if ("女".equals(request.getAttribute("sex"))) {
            %>
            <option value="">全部</option>
            <option value="男">男</option>
            <option value="女" selected>女</option>
            <%
                }
            %>
        </select>&nbsp;&nbsp;
            学历：<select name="education" class="mySelect">
            <%
                if (request.getAttribute("education") == null || "".equals(request.getAttribute("education"))) {
            %>
            <option value="" selected>全部</option>
            <option value="学士">学士</option>
            <option value="硕士">硕士</option>
            <option value="博士">博士</option>
            <%
            } else if ("学士".equals(request.getAttribute("education"))) {
            %>
            <option value="">全部</option>
            <option value="学士" selected>学士</option>
            <option value="硕士">硕士</option>
            <option value="博士">博士</option>
            <%
            } else if ("博士".equals(request.getAttribute("education"))) {
            %>
            <option value="">全部</option>
            <option value="学士">学士</option>
            <option value="硕士">硕士</option>
            <option value="博士" selected>博士</option>
            <%
            } else if ("硕士".equals(request.getAttribute("education"))) {
            %>
            <option value="">全部</option>
            <option value="学士">学士</option>
            <option value="硕士" selected>硕士</option>
            <option value="博士">博士</option>
            <%
                }
            %>
        </select> &nbsp;&nbsp;
            职称：<select name="title" class="mySelect">
            <%
                if (request.getAttribute("title") == null || "".equals(request.getAttribute("title"))) {
            %>
            <option value="" selected>全部</option>
            <option value="助教">助教</option>
            <option value="讲师">讲师</option>
            <option value="副教授">副教授</option>
            <option value="教授">教授</option>
            <%
            } else if ("助教".equals(request.getAttribute("title"))) {
            %>
            <option value="">全部</option>
            <option value="助教" selected>助教</option>
            <option value="讲师">讲师</option>
            <option value="副教授">副教授</option>
            <option value="教授">教授</option>
            <%
            } else if ("讲师".equals(request.getAttribute("title"))) {
            %>
            <option value="">全部</option>
            <option value="助教">助教</option>
            <option value="讲师" selected>讲师</option>
            <option value="副教授">副教授</option>
            <option value="教授">教授</option>
            <%
            } else if ("副教授".equals(request.getAttribute("title"))) {
            %>
            <option value="">全部</option>
            <option value="助教">助教</option>
            <option value="讲师">讲师</option>
            <option value="副教授" selected>副教授</option>
            <option value="教授">教授</option>
            <%
            } else if ("教授".equals(request.getAttribute("title"))) {
            %>
            <option value="">全部</option>
            <option value="助教">助教</option>
            <option value="讲师">讲师</option>
            <option value="副教授">副教授</option>
            <option value="教授" selected>教授</option>
            <%
                }
            %>
        </select>&nbsp;&nbsp;
            授课课程编号：<input type="text"  class="basic-slide" name="course"
                          value="<%=request.getAttribute("course")==null?"":request.getAttribute("course")%>"><br>
            <button onclick="sub()"
                    style="background: url(/resource/image/search.png);width: 113px;height: 40px;border: 0;">
            </button>
            <h2><input type="hidden"></h2>
            <h2 class="left_top"><a href="selectTeacher.action?insert=1"><img src="/resource/image/teacher.png" width="120" height="40" style="text-align: left"></a></h2>

        </h1>
        <table border="1px" id="keywords" cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th>序号</th>
                <th>教师编号</th>
                <th>教师姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>学历</th>
                <th>职称</th>
                <th>所授课程1</th>
                <th>所授课程2</th>
                <th>所授课程3</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                for (int i = 0; i < teachers.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + (i + 1) + "</td>");
                    out.print("<td>" + teachers.get(i).getTeacherNo() + "</td>");
                    out.print("<td>" + teachers.get(i).getTeacherName() + "</td>");
                    out.print("<td>" + teachers.get(i).getTeacherSex() + "</td>");
                    out.print("<td>" + teachers.get(i).getTeacherAge() + "</td>");
                    out.print("<td>" + teachers.get(i).getEducation() + "</td>");
                    out.print("<td>" + teachers.get(i).getProfessionalTitle() + "</td>");
                    out.print("<td>" + teachers.get(i).getCourseName1() + "</td>");
                    out.print("<td>" + teachers.get(i).getCourseName2() + "</td>");
                    out.print("<td>" + teachers.get(i).getCourseName3() + "</td>");
            %>
            <td>
                <input type="hidden" name="course1" value="<%=teachers.get(i).getCourseNo1()%>">
                <input type="hidden" name="course2" value="<%=teachers.get(i).getCourseNo2()%>">
                <input type="hidden" name="course3" value="<%=teachers.get(i).getCourseNo3()%>">
                <a href="<%=request.getContextPath()%>/deleteTeacher.action?teacherNo=<%=teachers.get(i).getTeacherNo()%>">删除</a>&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/selectTeacher.action?teacherNo=<%=teachers.get(i).getTeacherNo()%>&update=1">修改</a>
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
    <form method="post" action="download.action?type=teacher">
        <input type="hidden" name="teacherNo" value="<%=request.getAttribute("teacherNo")%>">
        <input type="hidden" name="teacherName" value="<%=request.getAttribute("teacherName")%>">
        <input type="hidden" name="teacherAge" value="<%=request.getAttribute("teacherAge")%>">
        <input type="hidden" name="teacherSex" value="<%=request.getAttribute("teacherSex")%>">
        <input type="hidden" name="education" value="<%=request.getAttribute("education")%>">
        <input type="hidden" name="professionalTitle" value="<%=request.getAttribute("professionalTitle")%>">
        <button onclick="sub2()"
                style="background: url(/resource/image/table.png);border: 0;width: 160px;height: 40px">
        </button>
    </form>
</div>
</body>
</html>