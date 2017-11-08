package com.cgc.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws javax.servlet.ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("/login.action")){
            chain.doFilter(req, resp);
        }
        if (session.getAttribute("username")!=null&&session.getAttribute("password")!=null){
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/login.action");
        }

    }

    public void init(FilterConfig config) throws javax.servlet.ServletException {
    }

}