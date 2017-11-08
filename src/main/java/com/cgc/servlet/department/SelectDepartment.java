package com.cgc.servlet.department;

import com.cgc.service.DepartmentService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/selectDepartment.action")
public class SelectDepartment extends HttpServlet {
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
        JSONArray array = JSONArray.fromObject(service.selectDepartment(Info));
        PrintWriter out = resp.getWriter();
        out.write(array.toString());
        out.flush();
        out.close();
    }
}
