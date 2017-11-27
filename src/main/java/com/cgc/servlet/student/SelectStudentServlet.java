package com.cgc.servlet.student;

import com.cgc.bean.Page;
import com.cgc.dao.NumberToNameDao;
import com.cgc.service.StudentService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/selectStudent.action")
public class SelectStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NumberToNameDao dao = new NumberToNameDao();
        List<Map<String, String>> maps = dao.DepartmentAndToName();
        Map<String, String> department = new HashMap<String, String>();
        for (Map<String, String> map : maps) {
            department.put(map.get("departmentNo"), map.get("departmentName"));
        }
        request.setAttribute("department",department);
        if (request.getParameter("insert")!=null){
            //院系编号和名称对应
            request.getRequestDispatcher("WEB-INF/jsp/student/insertStudent.jsp").forward(request,response);
        }
        String[] Info = new String[5];
        Info[0] = request.getParameter("studentNo");
        Info[1] = request.getParameter("name");
        Info[2] = request.getParameter("sex");
        Info[3] = request.getParameter("age");
        Info[4] = request.getParameter("departmentNo");
        request.setAttribute("studentNo",Info[0]);
        request.setAttribute("name",Info[1]);
        request.setAttribute("sex",Info[2]);
        request.setAttribute("age",Info[3]);
        request.setAttribute("departmentNo",Info[4]);
        StudentService service = new StudentService();
        //分页操作
        //获取页码
        String str = request.getParameter("page");
        int newPage;
        if (str != null) {
            newPage = Integer.valueOf(str);
        } else {
            newPage = 1;
        }
        int total = service.studentNumber(Info);
        Page page = new Page(total, 10);
        int totalPage = page.getTotalPage();
        //当前页是否大于总页数
        newPage = newPage > totalPage ? totalPage : newPage;
        //当前页是否小于1
        newPage = newPage < 1 ? 1 : newPage;
        request.setAttribute("page", newPage);
        request.setAttribute("total", totalPage);
        request.setAttribute("students",service.selectStudents(Info,page.getLimitNumber(newPage)));
        if (request.getParameter("update")!=null) {
            request.getRequestDispatcher("WEB-INF/jsp/student/updateStudent.jsp").forward(request,response);
        }
        request.getRequestDispatcher("WEB-INF/jsp/student/student.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
