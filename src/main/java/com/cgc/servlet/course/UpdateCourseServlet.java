package com.cgc.servlet.course;

import com.cgc.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateCourse.action")
public class UpdateCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] Info = new String[4];
        Info[0] = request.getParameter("courseNo");
        Info[1] = request.getParameter("courseName");
        Info[2] = request.getParameter("coursePriorNo");
        Info[3] = request.getParameter("courseCredit");
        CourseService service = new CourseService();
        response.setContentType("text/javascript;charset=utf-8");
        if (service.updateCourse(Info)) {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"修改成功\"}");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"修改失败，请查看输入的课程号是否正确\"}");
            out.flush();
            out.close();
        }
    }
}
