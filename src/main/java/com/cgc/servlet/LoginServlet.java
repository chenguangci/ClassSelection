package com.cgc.servlet;

import com.cgc.bean.User;
import com.cgc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username!=null && password!=null && !"".equals(username.trim()) && !"".equals(password.trim())) {
            UserService service = new UserService();
            Integer role = service.checkUser(username,password);
            if (role!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                session.setAttribute("role",role);
                response.sendRedirect("/begin.action");
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
