package com.cgc.servlet.select;

import com.cgc.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateSelectCourse.action")
public class UpdateSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[] Info = new String[4];
        Info[0] = request.getParameter("studentNo");
        Info[1] = request.getParameter("courseNo");
        Info[2] = request.getParameter("teacherNo");
        Info[3] = request.getParameter("grade");
        SelectCourseService service = new SelectCourseService();
        if (service.updateSelectCourse(Info)) {

        } else {

        }
    }
}
