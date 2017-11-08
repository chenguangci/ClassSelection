package com.cgc.servlet.student;

import com.cgc.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/insertStudent.action")
public class InsertStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[][] Info = new String[100][5];
        String[] no = request.getParameterValues("studentNo");
        String[] name = request.getParameterValues("studentName");
        String[] sex = request.getParameterValues("studentSex");
        String[] age = request.getParameterValues("studentAge");
        String[] departmentNo = request.getParameterValues("departmentNo");
        int len = no.length;
        for(int i=0;i<len;i++) {
            Info[i][0] = no[i];
            Info[i][1] = name[i];
            Info[i][2] = sex[i];
            Info[i][3] = age[i];
            Info[i][4] = departmentNo[i];
        }
        StudentService service = new StudentService();
        if (service.insertStudents(Info)) {
            //成功
        } else {
            //失败
        }
    }
}
