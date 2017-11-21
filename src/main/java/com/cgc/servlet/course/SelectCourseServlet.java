package com.cgc.servlet.course;

import com.cgc.bean.Page;
import com.cgc.service.CourseService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/selectCourse.action")
public class SelectCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert") != null) {
            request.getRequestDispatcher("WEB-INF/jsp/course/insertCourse.jsp").forward(request, response);
        }
        String[] Info = new String[4];
        Info[0] = request.getParameter("courseNo");
        Info[1] = request.getParameter("courseName");
        Info[2] = request.getParameter("coursePriorNo");
        Info[3] = request.getParameter("courseCredit");
        request.setAttribute("courseNo",Info[0]);
        request.setAttribute("courseName",Info[1]);
        request.setAttribute("coursePriorNo", Info[2]);
        request.setAttribute("courseCredit", Info[3]);
        CourseService service = new CourseService();
        //分页操作
        //获取页码
        String str = request.getParameter("page");
        int newPage;
        if (str != null) {
            newPage = Integer.valueOf(str);
        } else {
            newPage = 1;
        }
        int total = service.courseNumber(Info);
        Page page = new Page(total, 5);
        int totalPage = page.getTotalPage();
        //当前页是否大于总页数
        newPage = newPage > totalPage ? totalPage : newPage;
        //当前页是否小于1
        newPage = newPage < 1 ? 1 : newPage;
        request.setAttribute("page", newPage);
        request.setAttribute("total", totalPage);
        request.setAttribute("courses", service.selectCourse(Info, page.getLimitNumber(newPage)));
        //执行更新操作
        if (request.getParameter("update") != null) {
            request.getRequestDispatcher("WEB-INF/jsp/course/updateCourse.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/course/course.jsp").forward(request, response);
    }
}
