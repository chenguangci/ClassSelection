package com.cgc.servlet.teacher;

import com.cgc.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateTeacher.action")
public class UpdateTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] Info = new String[9];
        Info[0] = request.getParameter("teacherNo");
        Info[1] = request.getParameter("teacherName");
        Info[2] = request.getParameter("teacherSex");
        Info[3] = request.getParameter("teacherAge");
        Info[4] = request.getParameter("education");
        Info[5] = request.getParameter("title");
        Info[6] = request.getParameter("course1");
        Info[7] = request.getParameter("course2");
        Info[8] = request.getParameter("course3");
        TeacherService service = new TeacherService();
        response.setContentType("text/javascript;charset=utf-8");
        if (service.updateTeacher(Info)) {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"修改成功\"}");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"修改失败，请查看输入的课程号等信息是否正确\"}");
            out.flush();
            out.close();
        }
    }
}
