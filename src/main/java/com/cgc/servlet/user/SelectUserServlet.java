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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("insert")!=null) {
            request.getRequestDispatcher("/WEB-INF/jsp/user/insertUser.jsp").forward(request,response);
        }
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        UserService service = new UserService();
        request.setAttribute("username", username);
        request.setAttribute("role", role);
        request.setAttribute("users",service.selectUser(username, role));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/user/updateUser.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/user/user.jsp").forward(request,response);
    }
}
