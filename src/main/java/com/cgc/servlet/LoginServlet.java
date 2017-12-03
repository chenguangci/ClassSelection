package com.cgc.servlet;

import com.cgc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(value = "/login.action")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("out")!=null) {
            session.removeAttribute("username");
            session.removeAttribute("password");
            session.removeAttribute("role");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username!=null && password!=null && !"".equals(username.trim()) && !"".equals(password.trim())) {
            UserService service = new UserService();
            Integer role = service.checkUser(username,password);
            if (role!=null) {
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                session.setAttribute("role",role);
                request.getRequestDispatcher("/WEB-INF/jsp/begin.jsp").forward(request,response);
            } else {
                request.setAttribute("error","用户名或密码错误！");
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
