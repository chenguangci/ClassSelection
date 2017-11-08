package com.cgc.servlet.teacher;

import com.cgc.bean.Teacher;
import com.cgc.service.TeacherService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/selectTeacher.action")
public class SelectTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[] Info = new String[7];
        Info[0] = request.getParameter("teacherNo");
        Info[1] = request.getParameter("teacherName");
        Info[2] = request.getParameter("teacherSex");
        Info[3] = request.getParameter("teacherAge");
        Info[4] = request.getParameter("education");
        Info[5] = request.getParameter("title");
        Info[6] = request.getParameter("course");
        TeacherService service = new TeacherService();
        JSONArray array = JSONArray.fromObject(service.selectTeachers(Info));
        array.toString();
    }
}
