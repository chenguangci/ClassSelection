package com.cgc.servlet.department;

import com.cgc.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updateDepartment.action")
public class UpdateDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[] Info = new String[3];
        Info[0] = request.getParameter("departmentNo");
        Info[1] = request.getParameter("departmentName");
        Info[2] = request.getParameter("manager");
        DepartmentService service = new DepartmentService();
        if(service.updateDepartment(Info)) {
            //成功
        } else {
            //失败
        }
    }
}
