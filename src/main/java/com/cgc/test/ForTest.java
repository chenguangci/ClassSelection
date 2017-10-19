package com.cgc.test;

import com.cgc.bean.Course;
import com.cgc.service.CourseService;
import org.junit.Test;

import java.util.List;

public class ForTest {
    @Test
    public void courseTest(){
        CourseService courseService = new CourseService();

        //查找
        Object[] da = {"0001",null,null,null};
        List<Course> courses = courseService.selectCourse(da);
        for (Course course : courses){
            System.out.println(course.getCourseName());
        }
        /*
        //插入
        Object[][] dates = {{"0002","高等数学",null,4}};
        courseService.insertCourses(dates);

        //删除
        String[] ids = {"0001"};
        courseService.deleteCoursesById(ids);

        //更新
        Object[] date4 = {"0002","Java程序设计",null,4};
        courseService.updateCourse(date4);*/
    }

    @Test
    public void departmentTest(){

    }

}
