package com.cgc.servlet.student;

import com.cgc.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
@WebServlet(value = "/deleteStudent.action")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("studentNo");
        List<String> ids = Arrays.asList(id);
        StudentService service = new StudentService();
        if (service.deleteStudentsById(ids)) {
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
