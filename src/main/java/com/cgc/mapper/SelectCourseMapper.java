package com.cgc.mapper;

import com.cgc.bean.SelectCourse;

import java.util.List;

public interface SelectCourseMapper {
    /*查询所有选课信息*/
    List<SelectCourse> selectAllSelectCourse();
    /*按条件查询*/
    List<SelectCourse> selectSelectCourse(SelectCourse selectCourse);
    /*录入选课信息*/
    void insertSelectCourses(List<SelectCourse> selectCourses);
    /*删除选课信息*/
    void deleteSelectCourses(List<SelectCourse> selectCourses);
    /*更新选课信息*/
    void updateSelectCourse(SelectCourse selectCourse);
}
