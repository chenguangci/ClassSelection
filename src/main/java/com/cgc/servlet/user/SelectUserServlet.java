package com.cgc.servlet.user;

import com.cgc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户权限
 * 1：查看
 * 2：查看+下载
 * 3：查看+下载+报表
 * 4：查看+下载+报表+修改+删除
 * 5：用户信息修改
 */
@WebServlet(value = "/selectUser.action")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
        req.setAttribute("users",service.selectUser());
        req.getRequestDispatcher("WEB-INF/jsp/user/user.jsp").forward(req,resp);
    }
}
