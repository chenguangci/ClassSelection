package com.cgc.mapper;

import com.cgc.bean.Course;

import java.util.List;

public interface CourseMapper {
    /*查询所有课表*/
    List<Course> selectAllCourse();
    /*按条件查询*/
    List<Course> selectCourse(Course course);
    /*录入课表信息*/
    void insertCourses(List<Course> courses);
    /*删除课表信息*/
    void delectCoursesById(List<Integer> ids);
    /*更新课表信息*/
    void updateCourse(Course course);
}
