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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert")!=null){
            request.getRequestDispatcher("WEB-INF/jsp/department/insertDepartment.jsp").forward(request,response);
        }
        String[] Info = new String[3];
        Info[0] = request.getParameter("departmentNo");
        Info[1] = request.getParameter("departmentName");
        Info[2] = request.getParameter("manager");
        DepartmentService service = new DepartmentService();
        request.setAttribute("departments",service.selectDepartment(Info));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/department/updateDepartment.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/department/department.jsp").forward(request,response);
    }
}
