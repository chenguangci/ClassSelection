package com.cgc.servlet.user;

import com.cgc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/updateUser.action")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/javascript;charset=utf-8");
        String[] info = new String[5];
        info[0] = request.getParameter("username");
        info[1] = request.getParameter("newPassword");
        info[2] = request.getParameter("role");
        info[3] = request.getParameter("oldPassword");
        info[4] = request.getParameter("confirm");
        HttpSession session = request.getSession();
        if ("5".equals(session.getAttribute("role"))) {
            info[2] = "5";
        }
        UserService service = new UserService();
        for (String str:info) {
            if (str==null||"".equals(str.trim())){
                out.write("{\"success\":false,\"msg\":\"请将信息填写完整\"}");
                out.flush();
                out.close();
            }
        }
        if (service.checkUser(info[0], info[3])==null) {
            out.write("{\"success\":false,\"msg\":\"输入的原密码错误\"}");
            out.flush();
            out.close();
        } else if (!info[1].equals(info[4])) {
            out.write("{\"success\":false,\"msg\":\"输入的两次密码不一致\"}");
            out.flush();
            out.close();
        } else if (service.updateUser(info)){
            out.write("{\"success\":false,\"msg\":\"更新成功\"}");
            out.flush();
            out.close();
        } else {
            out.write("{\"success\":false,\"msg\":\"发生未知错误，更新失败\"}");
            out.flush();
            out.close();
        }
    }
}
