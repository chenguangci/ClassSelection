package com.cgc.servlet.select;

import com.cgc.bean.Page;
import com.cgc.service.SelectCourseService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/selectSelectCourse.action")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert")!=null){
            request.getRequestDispatcher("WEB-INF/jsp/select/insertSelectCourse.jsp").forward(request,response);
        }
        String[] Info = new String[4];
        Info[0] = request.getParameter("studentNo");
        Info[1] = request.getParameter("courseNo");
        Info[2] = request.getParameter("teacherNo");
        //Info[3] = request.getParameter("grade");
        request.setAttribute("studentNo",Info[0]);
        request.setAttribute("courseNo",Info[1]);
        request.setAttribute("teacherNo",Info[2]);
        SelectCourseService service = new SelectCourseService();
        //分页操作
        //获取页码
        String str = request.getParameter("page");
        int newPage;
        if (str != null) {
            newPage = Integer.valueOf(str);
        } else {
            newPage = 1;
        }
        int total = service.selectNumber(Info);
        Page page = new Page(total, 5);
        int totalPage = page.getTotalPage();
        //当前页是否大于总页数
        newPage = newPage > totalPage ? totalPage : newPage;
        //当前页是否小于1
        newPage = newPage < 1 ? 1 : newPage;
        request.setAttribute("page", newPage);
        request.setAttribute("total", totalPage);
        request.setAttribute("selects",service.selectSelectCourse(Info,page.getLimitNumber(newPage)));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/select/updateSelectCourse.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/select/select.jsp").forward(request,response);
    }
}
