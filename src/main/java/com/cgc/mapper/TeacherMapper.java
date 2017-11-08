package com.cgc.mapper;

import com.cgc.bean.Teacher;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    /*按条件查询*/
    List<Teacher> selectTeachers(Teacher teacher);
    /*录入教师信息*/
    void insertTeachers(List<Teacher> teachers);
    /*删除教师信息*/
    void deleteTeachersById(List<String> ids);
    /*更新教师信息*/
    void updateTeacher(Map<String,Object> teacher);
}
