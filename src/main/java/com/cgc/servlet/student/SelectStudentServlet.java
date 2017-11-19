package com.cgc.servlet.student;

import com.cgc.service.StudentService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/selectStudent.action")
public class SelectStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert")!=null){
            request.getRequestDispatcher("WEB-INF/jsp/student/insertStudent.jsp").forward(request,response);
        }
        String[] Info = new String[5];
        Info[0] = request.getParameter("studentNo");
        Info[1] = request.getParameter("name");
        Info[2] = request.getParameter("sex");
        Info[3] = request.getParameter("age");
        Info[4] = request.getParameter("departmentNo");
        StudentService service = new StudentService();
        request.setAttribute("students",service.selectStudents(Info));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/student/updateStudent.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/student/student.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
