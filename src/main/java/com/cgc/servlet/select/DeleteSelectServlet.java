package com.cgc.servlet.select;

import com.cgc.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/deleteSelectCourse.action")
public class DeleteSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] student = request.getParameterValues("studentNo");
        String[] course = request.getParameterValues("courseNo");
        String[] teacher = request.getParameterValues("teacherNo");
        int len = student.length;
        String[][] Info = new String[100][3];
        for (int i=0;i<len;i++) {
            Info[i][1] = course[i];
            Info[i][2] = teacher[i];
            Info[i][0] = student[i];
        }
        SelectCourseService service = new SelectCourseService();
        if (service.deleteSelectCourses(Info)) {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true}");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":false,\"msg\":\"删除数据失败\"}");
            out.flush();
            out.close();
        }
    }
}
