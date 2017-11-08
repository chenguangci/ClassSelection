package com.cgc.servlet.teacher;

import com.cgc.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@WebServlet(value = "/deleteTeacher.action")
public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] id = req.getParameterValues("teacherNo");
        List<String> ids = Arrays.asList(id);
        TeacherService service = new TeacherService();
        if (service.deleteTeachersById(ids)) {

        } else {

        }
    }
}
