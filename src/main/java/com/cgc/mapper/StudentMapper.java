package com.cgc.mapper;

import com.cgc.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /*按条件查询*/
    List<Student> selectStudents(Student student);
    /*录入学生信息*/
    void insertStudents(List<Student> students);
    /*删除学生信息*/
    void deleteStudentsById(List<Integer> ids);
    /*更新学生信息*/
    void updateStudent(Map<String,Object> student);
}
