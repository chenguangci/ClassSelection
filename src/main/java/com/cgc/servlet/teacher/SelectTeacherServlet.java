package com.cgc.servlet.teacher;

import com.cgc.bean.Page;
import com.cgc.service.TeacherService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/selectTeacher.action")
public class SelectTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert")!=null){
            request.getRequestDispatcher("WEB-INF/jsp/teacher/insertTeacher.jsp").forward(request,response);
        }
        String[] Info = new String[7];
        Info[0] = request.getParameter("teacherNo");
        Info[1] = request.getParameter("teacherName");
        Info[2] = request.getParameter("teacherSex");
        Info[3] = request.getParameter("teacherAge");
        Info[4] = request.getParameter("education");
        Info[5] = request.getParameter("title");
        Info[6] = request.getParameter("course");
        request.setAttribute("teacherNo",Info[0]);
        request.setAttribute("teacherName",Info[1]);
        request.setAttribute("sex",Info[2]);
        request.setAttribute("teacherAge",Info[3]);
        request.setAttribute("education",Info[4]);
        request.setAttribute("title",Info[5]);
        request.setAttribute("course",Info[6]);
        TeacherService service = new TeacherService();
        //分页操作
        //获取页码
        String str = request.getParameter("page");
        int newPage;
        if (str != null) {
            newPage = Integer.valueOf(str);
        } else {
            newPage = 1;
        }
        int total = service.teacherNumber(Info);
        Page page = new Page(total, 10);
        int totalPage = page.getTotalPage();
        //当前页是否大于总页数
        newPage = newPage > totalPage ? totalPage : newPage;
        //当前页是否小于1
        newPage = newPage < 1 ? 1 : newPage;
        request.setAttribute("page", newPage);
        request.setAttribute("total", totalPage);
        request.setAttribute("teachers",service.selectTeachers(Info,page.getLimitNumber(newPage)));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/teacher/updateTeacher.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/teacher/teacher.jsp").forward(request,response);
    }
}
