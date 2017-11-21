package com.cgc.mapper;

import com.cgc.bean.Teacher;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    int teacherNumber(@Param("teacher") Teacher teacher);
    /*按条件查询*/
    List<Teacher> selectTeachers(@Param("teacher") Teacher teacher, @Param("limit") int limit);
    /*录入教师信息*/
    void insertTeachers(List<Teacher> teachers);
    /*删除教师信息*/
    void deleteTeachersById(List<String> ids);
    /*更新教师信息*/
    void updateTeacher(Map<String,Object> teacher);
}
