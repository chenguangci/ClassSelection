package com.cgc.servlet.user;

import com.cgc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/insertUser.action")
public class InsertUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String[] info = new String[3];
        info[0] = request.getParameter("username");
        info[1] = request.getParameter("password");
        /*
        权限以复选框形式勾选，分4级权限，后面在修改
         */
        info[2] = request.getParameter("role");
        UserService service = new UserService();
        if(service.insertUser(info)) {

        } else {

        }
    }
}
