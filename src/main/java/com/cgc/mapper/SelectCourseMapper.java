package com.cgc.mapper;

import com.cgc.bean.SelectCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCourseMapper {
    int selectNumber(@Param("selectCourse") SelectCourse selectCourse);
    /*按条件查询*/
    List<SelectCourse> selectSelectCourse(@Param("selectCourse") SelectCourse selectCourse, @Param("limit") int limit);
    /*录入选课信息*/
    void insertSelectCourses(SelectCourse selectCourse);
    /*删除选课信息*/
    void deleteSelectCourses(List<SelectCourse> selectCourses);
    /*更新选课信息*/
    void updateSelectCourse(SelectCourse selectCourse);
}
