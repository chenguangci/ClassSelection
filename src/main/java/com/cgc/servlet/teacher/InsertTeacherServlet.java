package com.cgc.servlet.teacher;

import com.cgc.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/insertTeacher.action")
public class InsertTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] no = request.getParameterValues("teacherNo");
        String[] name = request.getParameterValues("teacherName");
        String[] sex = request.getParameterValues("teacherSex");
        String[] age = request.getParameterValues("teacherAge");
        String[] education = request.getParameterValues("education");
        String[] title = request.getParameterValues("title");
        String[] course1 = request.getParameterValues("courseNo1");
        String[] course2 = request.getParameterValues("courseNo2");
        String[] course3 = request.getParameterValues("courseNo3");
        int len = no.length;
        String[][] Info = new String[len][9];
        for (int i=0;i<len;i++){
            Info[i][0] = no[i];
            Info[i][1] = name[i];
            Info[i][2] = sex[i];
            Info[i][3] = age[i];
            Info[i][4] = education[i];
            Info[i][5] = title[i];
            Info[i][6] = course1[i];
            Info[i][7] = course2[i];
            Info[i][8] = course3[i];
        }
        TeacherService service = new TeacherService();
        if (service.insertTeachers(Info)) {
            response.sendRedirect("/selectTeacher.action");
        } else {

        }
    }
}
