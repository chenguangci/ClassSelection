package com.cgc.mapper;

import com.cgc.bean.Teacher;

import java.util.List;

public interface TeacherMapper {
    /*按条件查询*/
    List<Teacher> selectTeachers(Teacher teacher);
    /*录入教师信息*/
    void insertTeachers(List<Teacher> teachers);
    /*删除教师信息*/
    void deleteTeachersById(List<Integer> ids);
    /*更新教师信息*/
    void updateTeacher(Teacher teacher);
}
