package com.cgc.mapper;

import com.cgc.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int studentNumber(@Param("student") Student student);
    /*按条件查询*/
    List<Student> selectStudents(@Param("student") Student student, @Param("limit") int limit);
    /*录入学生信息*/
    void insertStudents(Student student);
    /*删除学生信息*/
    void deleteStudentsById(List<String> ids);
    /*更新学生信息*/
    void updateStudent(Map<String,Object> student);
}
