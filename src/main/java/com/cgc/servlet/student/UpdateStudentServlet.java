package com.cgc.servlet.student;

import com.cgc.service.StudentService;
import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/updateStudent.action")
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] Info = new String[5];
        Info[0] = request.getParameter("studentNo");
        Info[1] = request.getParameter("name");
        Info[2] = request.getParameter("sex");
        Info[3] = request.getParameter("age");
        Info[4] = request.getParameter("departmentNo");
        StudentService service = new StudentService();
        if (service.updateStudent(Info)) {
            response.sendRedirect("/selectStudent.action");
        } else {
            //失败
        }
    }
}
