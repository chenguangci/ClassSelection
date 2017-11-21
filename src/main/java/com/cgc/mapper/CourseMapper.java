package com.cgc.mapper;

import com.cgc.bean.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    int courseNumber(@Param("course") Course course);
    /*按条件查询*/
    List<Course> selectCourse(@Param("course") Course course,  @Param("limit") int limitNumber);
    /*录入课表信息*/
    void insertCourses(List<Course> courses);
    /*删除课表信息*/
    void deleteCoursesById(List<String> ids);
    /*更新课表信息*/
    void updateCourse(Map<String,Object> course);
}
