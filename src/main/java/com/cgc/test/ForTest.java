package com.cgc.test;

import com.cgc.bean.Page;
import com.cgc.bean.Student;
import com.cgc.bean.Teacher;
import com.cgc.dao.Download;
import com.cgc.dao.NumberToNameDao;
import com.cgc.service.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForTest {
    @Test
    public void courseTest() {
        CourseService courseService = new CourseService();

        //查找
//        String[] da = {null, null, null, null};
//        List<Course> courses = courseService.selectCourse(da, 0);
//        for (Course course : courses) {
//            System.out.println("课程名："+course.getCourseName()+" 先修课程号："+course.getCoursePriorNo()+" 先修课程名："+course.getCoursePriorName());
//
//        }

        //插入
        String[][] dates = {{"0016", "springMVC", "0002", "4"}};
        System.out.println(courseService.insertCourses(dates));
        /*
        //删除
        String[] ids = {"0001"};
        courseService.deleteCoursesById(ids);

        //更新
        Object[] date4 = {"0002","Java程序设计",null,4};
        courseService.updateCourse(date4);*/

//        List<Map<String, String>> lists = courseService.getCourseNoAndName();
//        for (Map<String, String> list : lists) {
//            for (Map.Entry entry : list.entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//        }
    }

    @Test
    public void departmentTest() {
        //String[][] info = {{"0006","工程学院","陈主任"},{"0007","旅游学院","陈主任"}};
        DepartmentService service = new DepartmentService();
        //service.selectDepartment(info[0]);
        List<String> ids = new ArrayList<String>();
        ids.add("0007");
        ids.add("0006");
        System.out.println(service.deleteDepartmentsById(ids));
        String[] info1 = {"0001", "计算机科学与软件学院", "陈主任"};
        System.out.println(service.updateDepartment(info1));
        //System.out.println(service.insertDepartments(info));
    }

    @Test
    public void studentTest() {
        String[][] info = {{"20153112", "碧池", "男", "19", "0001"}, {"20153111", "小红", "女", "19", "0001"}};
//        List<String> ids = new ArrayList<String>();
//        ids.add("20150001");
//        ids.add("20150002");
//        ids.add("20150003");
        String[] info1 = new String[5];
        StudentService service = new StudentService();
        List<Student> students = service.selectStudents(info1, 0);
        for (Student student : students) {
            System.out.println(student.getStudentName() + " " + student.getDepartmentName());
        }
        //System.out.println(service.updateStudent(info[0]));
    }

    @Test
    public void teacherTest() {
        String[][] info = {{"20000101", "小李", "男", "39", "硕士", "教授", "0001", "0002", "0003"}, {"20000102", "小刘", "女", "30", "博士", "教授", "0001", "0002", "0003"}, {" ", null, null, null, null, null, "0004", null, null}};
        TeacherService service = new TeacherService();
        //System.out.println(service.insertTeachers(info));
        //System.out.println(service.updateTeacher(info[1]));
        //System.out.println(service.deleteTeachersById(ids));
        //System.out.println(service.selectTeachers(info[1]));
        String[] info1 = new String[9];
        List<Teacher> teachers = service.selectTeachers(info1, 0);
        NumberToNameDao dao = new NumberToNameDao();
        List<Map<String, String>> maps = dao.CourseNoAndName();
        Map<String, String> courses = new HashMap<String, String>();
        for (Map<String, String> map : maps) {
            courses.put(map.get("courseNo"), map.get("courseName"));
        }
        for (Teacher teacher : teachers) {
            if (teacher.getCourseNo1() != null)
                teacher.setCourseName1(courses.get(teacher.getCourseNo1()));
            if (teacher.getCourseNo2() != null)
                teacher.setCourseName2(courses.get(teacher.getCourseNo2()));
            if (teacher.getCourseNo3() != null)
                teacher.setCourseName3(courses.get(teacher.getCourseNo3()));
            System.out.println(teacher.getTeacherName() + " " + teacher.getCourseName1() + " " + teacher.getCourseName2() + " " + teacher.getCourseName3());
        }

    }

    @Test
    public void userTest() {
        String[] info = {"snow", "123", "5"};
        UserService service = new UserService();
        System.out.println(service.insertUser(info));
        String username = "snow";
        String password = "120";
        System.out.println(service.checkUser(username, password));
    }

    @Test
    public void pageTest() {
        //分页操作
        Page page = new Page(18, 5);
        System.out.println(page.getLimitNumber(2) + "   " + page.getTotalPage());
    }

//    @Test
//    public void download() {
//        DownloadService downloadService = new DownloadService();
//        HSSFWorkbook workbook = downloadService.select("student");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("G:/Members.xls");
//            workbook.write(fileOutputStream);
//            fileOutputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testStr(){
        Download download = new Download();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("courseNo","1");
        //param.put("courseName","C");
        //param.put("coursePriorNo","2");
        param.put("courseCredit",null);
        System.out.println(null instanceof Integer);
        //List<Map<String,Object>> objects = download.select("course", param);
    }
    @Test
    public void test1(){
        Object str = null;
        Integer i = Integer.valueOf((String)str);
        System.out.println(i);
    }

}
