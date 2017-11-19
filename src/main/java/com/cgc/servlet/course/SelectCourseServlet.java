package com.cgc.servlet.course;

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
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert")!=null){
            request.getRequestDispatcher("WEB-INF/jsp/course/insertCourse.jsp").forward(request,response);
        }
        String[] Info = new String[4];
        Info[0] = request.getParameter("courseNo");
        Info[1] = request.getParameter("courseName");
        Info[2] = request.getParameter("coursePriorNo");
        Info[3] = request.getParameter("courseCredit");
        CourseService service = new CourseService();
        request.setAttribute("courses",service.selectCourse(Info));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/course/updateCourse.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/course/course.jsp").forward(request,response);
    }
}
