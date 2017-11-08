package com.cgc.servlet.course;

import com.cgc.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/updateCourse.action")
public class UpdateCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[] Info = new String[4];
        Info[0] = request.getParameter("courseNo");
        Info[1] = request.getParameter("courseName");
        Info[2] = request.getParameter("coursePriorNo");
        Info[3] = request.getParameter("courseCredit");
        CourseService service = new CourseService();
        if (service.updateCourse(Info)) {

        } else {

        }
    }
}
