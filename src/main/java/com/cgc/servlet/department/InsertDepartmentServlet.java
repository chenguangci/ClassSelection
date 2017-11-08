package com.cgc.servlet.department;

import com.cgc.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/insertDepartment.action")
public class InsertDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[][] Info = new String[100][3];
        String[] no = request.getParameterValues("departmentNo");
        String[] name = request.getParameterValues("departmentName");
        String[] manager = request.getParameterValues("manager");
        int len = no.length;
        for (int i=0;i<len;i++){
            Info[i][0] = no[i];
            Info[i][1] = name[i];
            Info[i][2] = manager[i];
        }
        DepartmentService service = new DepartmentService();
        if (service.insertDepartments(Info)) {
            //插入成功
        } else {
            //失败
        }
    }
}
