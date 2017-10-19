package com.cgc.service;

import com.cgc.bean.Student;
import com.cgc.dao.StudentDao;

import java.util.List;
import java.util.Map;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
    /**
     * 获取学生信息
     */
    public List<Student> selectStudents(Student student){
        return studentDao.selectStudents(student);
    }
    /**
     * 录入学生信息
     */
    public void insertStudents(List<Student> students){
        studentDao.insertStudents(students);
    }
    /**
     * 删除学生信息
     */
    public void deleteStudentsById(List<Integer> ids){
        studentDao.deleteStudentsById(ids);
    }
    /**
     * 更改学生信息
     */
    public void updateStudent(Map<String,Object> student){
        studentDao.updateStudent(student);
    }
}
