package com.cgc.servlet.filter;

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
@WebFilter(urlPatterns = {"*.action"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws javax.servlet.ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        req.setCharacterEncoding("utf-8");
        if ((session.getAttribute("username")!=null&&session.getAttribute("password")!=null) || request.getRequestURI().contains("/login.action") || request.getRequestURI().contains("/resource")) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("/login.action").forward(request,response);
        }

    }

    public void init(FilterConfig config) throws javax.servlet.ServletException {
    }

}
