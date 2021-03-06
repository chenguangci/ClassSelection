package com.cgc.servlet.department;

import com.cgc.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateDepartment.action")
public class UpdateDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] Info = new String[3];
        Info[0] = request.getParameter("departmentNo");
        Info[1] = request.getParameter("departmentName");
        Info[2] = request.getParameter("manager");
        DepartmentService service = new DepartmentService();
        response.setContentType("text/javascript;charset=utf-8");
        if (service.updateDepartment(Info)) {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"修改成功\"}");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"修改失败，请查看输入的信息是否有误\"}");
            out.flush();
            out.close();
        }
    }
}
