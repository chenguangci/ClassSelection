package com.cgc.servlet.select;

import com.cgc.service.SelectCourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateSelectCourse.action")
public class UpdateSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] Info = new String[4];
        String id = request.getParameter("id");
        Info[0] = request.getParameter("studentNo");
        Info[1] = request.getParameter("courseNo");
        Info[2] = request.getParameter("teacherNo");
        Info[3] = request.getParameter("grade");
        SelectCourseService service = new SelectCourseService();
        response.setContentType("text/javascript;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (Info[0] == null || "".equals(Info[0]) || Info[1] == null || "".equals(Info[1]) || Info[2] == null || "".equals(Info[2])) {
            out.write("{\"success\":true,\"msg\":\"缺少必要信息\"}");
            out.flush();
            out.close();
        }
        if (service.updateSelectCourse(Info,id)) {
            out.write("{\"success\":true,\"msg\":\"修改成功\"}");
            out.flush();
            out.close();
        } else {
            out.write("{\"success\":true,\"msg\":\"修改失败，请查看输入的各个编号是否正确\"}");
            out.flush();
            out.close();
        }
    }
}
