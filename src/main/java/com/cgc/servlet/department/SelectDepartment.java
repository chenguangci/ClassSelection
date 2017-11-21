package com.cgc.servlet.department;

import com.cgc.bean.Page;
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
        request.setAttribute("departmentNo",Info[0]);
        request.setAttribute("departmentName",Info[1]);
        request.setAttribute("manager",Info[2]);
        DepartmentService service = new DepartmentService();
        //分页操作
        //获取页码
        String str = request.getParameter("page");
        int newPage;
        if (str != null) {
            newPage = Integer.valueOf(str);
        } else {
            newPage = 1;
        }
        int total = service.departmentNumber(Info);
        Page page = new Page(total, 5);
        int totalPage = page.getTotalPage();
        //当前页是否大于总页数
        newPage = newPage > totalPage ? totalPage : newPage;
        //当前页是否小于1
        newPage = newPage < 1 ? 1 : newPage;
        request.setAttribute("page", newPage);
        request.setAttribute("total", totalPage);
        request.setAttribute("departments",service.selectDepartment(Info,page.getLimitNumber(newPage)));

        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/department/updateDepartment.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/department/department.jsp").forward(request,response);
    }
}
