package com.cgc.test;

import com.cgc.bean.Course;
import com.cgc.service.CourseService;
import com.cgc.service.DepartmentService;
import com.cgc.service.StudentService;
import com.cgc.service.TeacherService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    @Test
    public void courseTest(){
        CourseService courseService = new CourseService();

        //查找
        String[] da = {"0001",null,null,null};
        List<Course> courses = courseService.selectCourse(da);
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
        String[][] info = {{"20153112","小胡","男","19","0001"},{"20153111","小红","女","19","0001"}};
        List<String> ids = new ArrayList<String>();
        ids.add("20150001");
        ids.add("20150002");
        ids.add("20150003");

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
        System.out.println(service.selectTeachers(info[1]));
    }

}
