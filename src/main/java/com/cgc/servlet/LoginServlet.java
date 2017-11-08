package com.cgc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("123".equals(request.getParameter("username"))&&"123".equals(request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("username","123");
            session.setAttribute("password","123");
            response.sendRedirect("/begin.action");
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
