package com.cgc.servlet.course;

import com.cgc.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/insertCourse.action")
public class InsertCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] no = request.getParameterValues("courseNo");
        String[] name = request.getParameterValues("courseName");
        String[] pNo = request.getParameterValues("coursePriorNo");
        String[] credit = request.getParameterValues("courseCredit");
        int len = no.length;
        String[][] Info = new String[len][4];
        boolean isNull = false;
        for (int i=0;i<len;i++){
            if (no[i]==null||"".equals(no[i].trim())||name[i]==null||"".equals(name[i].trim())||credit[i]==null||"".equals(credit[i].trim())){
                isNull = true;
                break;
            }
            Info[i][0] = no[i];
            Info[i][1] = name[i];
            Info[i][2] = pNo[i];
            Info[i][3] = credit[i];
        }
        CourseService service = new CourseService();
        if (isNull||!service.insertCourses(Info)) {
            request.getRequestDispatcher("WEB-INF/jsp/course/insertCourse.jsp?error=1").forward(request,response);
        } else {
            response.sendRedirect("/selectCourse.action");
        }
    }
}
