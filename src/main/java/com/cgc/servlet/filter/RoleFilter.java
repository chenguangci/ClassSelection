package com.cgc.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(value = "*.action")
public class RoleFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        //如果为登陆请求或进入首页则放行
        if (uri.contains("/login.action") || uri.contains("/begin.action")) {
            chain.doFilter(req,resp);
        } else {
            if (session.getAttribute("role") == null) {
                request.getRequestDispatcher("/login.action").forward(request,response);
            } else {
                response.setContentType("text/javascript;charset=utf-8");
                Integer role = (Integer) session.getAttribute("role");
                //用户权限控制
                if (uri.contains("User")) {
                    if (role>=5){
                        chain.doFilter(req,resp);
                    } else {
                        //提示权限不够
                        request.setAttribute("error","对不起，您的权限不足，无法查看用户信息");
                        request.getRequestDispatcher("WEB-INF/jsp/begin.jsp").forward(request,response);
                    }
                }
                else if (uri.contains("select")) {
                    //管理员最低权限也能进行查询，无需权限级别判断
                    chain.doFilter(req,resp);
                }
                //增加权限控制
                else if (uri.contains("insert")) {
                    if (role>=3) {
                        chain.doFilter(req,resp);
                    } else {
                        //提示权限不够
                        PrintWriter out = response.getWriter();
                        out.write("{\"success\":true,\"msg\":\"对不起，您的权限不足，无法插入数据\"}");
                        out.flush();
                        out.close();
                    }
                }
                //删改权限控制
                else if (uri.contains("update") || uri.contains("delete")) {
                    if (role>=4) {
                        chain.doFilter(req,resp);
                    } else {
                        //提示权限不够
                        PrintWriter out = response.getWriter();
                        out.write("{\"success\":false,\"msg\":\"对不起，您的权限不足，进行此数据操作\"}");
                        out.flush();
                        out.close();
                    }
                }
                //
                else {
                    chain.doFilter(req, resp);
                }
            }

        }
    }
}
