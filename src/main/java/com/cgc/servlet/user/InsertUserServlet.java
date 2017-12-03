package com.cgc.servlet.user;

import com.cgc.service.UserService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/insertUser.action")
public class InsertUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String[] info = new String[3];
        info[0] = request.getParameter("username");
        info[1] = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        info[2] = request.getParameter("role");
        for (String str:info) {
            if (str==null||"".equals(str.trim())) {
                out.write("{\"success\":false,\"msg\":\"请将信息填写完整\"}");
                out.flush();
                out.close();
            }
        }
        if (!info[1].equals(confirm)) {
            out.write("{\"success\":false,\"msg\":\"两次密码不一致\"}");
            out.flush();
            out.close();
        }

        UserService service = new UserService();
        if(service.insertUser(info)) {
            out.write("{\"success\":true,\"msg\":\"插入数据成功\"}");
            out.flush();
            out.close();
        } else {
            out.write("{\"success\":false,\"msg\":\"数据插入失败,可能是用户名重复\"}");
            out.flush();
            out.close();
        }
    }
}
