package com.cgc.mapper;

import com.cgc.bean.Student;

import java.util.List;

public interface StudentMapper {
    /*查询所有学生信息*/
    List<Student> selectAllStudents();
    /*按条件查询*/
    List<Student> selectStudents(Student student);
    /*录入学生信息*/
    void insertStudents(List<Student> students);
    /*删除学生信息*/
    void deleteStudentsById(List<Integer> ids);
    /*更新学生信息*/
    void updateStudent(Student student);
}
