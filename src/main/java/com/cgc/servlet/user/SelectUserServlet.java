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
@WebServlet(value = "/selectUser.action")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
        JSONArray array = JSONArray.fromObject(service.selectUser());
        PrintWriter out = resp.getWriter();
        out.write(array.toString());
        out.flush();
        out.close();
    }
}
