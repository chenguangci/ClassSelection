package com.cgc.test;

import com.cgc.bean.Course;
import com.cgc.bean.Page;
import com.cgc.service.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    @Test
    public void courseTest(){
        CourseService courseService = new CourseService();

        //查找
        String[] da = {null,null,null,null};
        List<Course> courses = courseService.selectCourse(da,0);
        for (Course course : courses){
            System.out.println(course.getCourseName());
        }

        //插入
        String[][] dates = {{"0003","数据库管理",null,"4"}};
        courseService.insertCourses(dates);
        /*
        //删除
        String[] ids = {"0001"};
        courseService.deleteCoursesById(ids);

        //更新
        Object[] date4 = {"0002","Java程序设计",null,4};
        courseService.updateCourse(date4);*/
    }

    @Test
    public void departmentTest(){
        //String[][] info = {{"0006","工程学院","陈主任"},{"0007","旅游学院","陈主任"}};
        DepartmentService service = new DepartmentService();
        //service.selectDepartment(info[0]);
        List<String> ids = new ArrayList<String>();
        ids.add("0007");
        ids.add("0006");
        System.out.println(service.deleteDepartmentsById(ids));
        String[] info1 = {"0001","计算机科学与软件学院","陈主任"};
        System.out.println(service.updateDepartment(info1));
        //System.out.println(service.insertDepartments(info));
    }

    @Test
    public void studentTest(){
        String[][] info = {{"20153112","碧池","男","19","0001"},{"20153111","小红","女","19","0001"}};
//        List<String> ids = new ArrayList<String>();
//        ids.add("20150001");
//        ids.add("20150002");
//        ids.add("20150003");

        StudentService service = new StudentService();
        System.out.println(service.updateStudent(info[0]));
    }

    @Test
    public void teacherTest(){
        String[][] info = {{"20000101","小李","男","39","硕士","教授","0001","0002","0003"},{"20000102","小刘","女","30","博士","教授","0001","0002","0003"},{" ",null,null,null,null,null,"0004",null,null}};
        TeacherService service = new TeacherService();
        //System.out.println(service.insertTeachers(info));
        //System.out.println(service.updateTeacher(info[1]));
        List<String> ids = new ArrayList<String>();
        ids.add("200001");
        //System.out.println(service.deleteTeachersById(ids));
        //System.out.println(service.selectTeachers(info[1]));
    }

    @Test
    public void userTest(){
        String[] info = {"snow","123","5"};
        UserService service = new UserService();
        System.out.println(service.insertUser(info));
        String username = "snow";
        String password = "120";
        System.out.println(service.checkUser(username,password));
    }

    @Test
    public void pageTest() {
        //分页操作
        Page page = new Page(18,5);
        System.out.println(page.getLimitNumber(2)+"   "+page.getTotalPage());
    }

}
