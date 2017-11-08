package com.cgc.servlet.student;

import com.cgc.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@WebServlet(value = "/deleteStudent.action")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] id = req.getParameterValues("studentNo");
        List<String> ids = Arrays.asList(id);
        StudentService service = new StudentService();
        if (service.deleteStudentsById(ids)) {
            //成功
        } else {
            //失败
        }
    }
}
