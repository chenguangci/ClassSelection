package com.cgc.servlet.select;

import com.cgc.service.SelectCourseService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/insertSelectCourse.action")
public class InsertSelectServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] student = request.getParameterValues("studentNo");
        String[] course = request.getParameterValues("courseNo");
        String[] teacher = request.getParameterValues("teacherNo");
        String[] grade = request.getParameterValues("grade");
        int len = student.length;
        String[][] Info = new String[len][4];
        for (int i=0;i<len;i++) {
            Info[i][1] = course[i];
            Info[i][2] = teacher[i];
            Info[i][3] = grade[i];
            Info[i][0] = student[i];
        }
        SelectCourseService service = new SelectCourseService();
        int[] total = service.insertSelectCourses(Info);
        StringBuilder msg = new StringBuilder("第");
        boolean isSuccess = true;
        for (int i=0; i<total.length; i++) {
            if (total[i] == 0) {
                isSuccess = false;
                msg.append(String.valueOf((i+1))).append(",");
            }
        }

        response.setContentType("text/javascript;charset=utf-8");
        if (isSuccess) {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true,\"msg\":\"插入数据成功\"}");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            String array = (JSONArray.fromObject(total)).toString();
            out.write("{\"success\":false,\"msg\":\""+msg.toString().substring(0,msg.toString().length()-1)+"条数据插入失败\",\"array\":\""+array+"\"}");
            out.flush();
            out.close();
        }
    }
}
