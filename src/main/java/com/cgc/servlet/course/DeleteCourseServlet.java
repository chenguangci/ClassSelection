package com.cgc.servlet.course;

import com.cgc.service.CourseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@WebServlet(value = "/deleteCourse.action")
public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("courseNo");
        System.out.println("课程号为："+id[0]);
        List<String> ids = Arrays.asList(id);
        CourseService service = new CourseService();
        if (service.deleteCoursesById(ids)) {
            response.sendRedirect("/selectCourse.action");
        } else {

        }
    }
}
