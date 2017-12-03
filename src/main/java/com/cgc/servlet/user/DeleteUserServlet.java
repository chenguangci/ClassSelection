package com.cgc.servlet.user;

import com.cgc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/deleteUser.action")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        if (service.checkUser(name,password)==null)  {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":false,\"msg\":\"输入密码错误\"}");
            out.flush();
            out.close();
        } else if (service.deleteUser(name)) {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":true}");
            out.flush();
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("{\"success\":false,\"msg\":\"删除数据失败\"}");
            out.flush();
            out.close();
        }
    }
}
