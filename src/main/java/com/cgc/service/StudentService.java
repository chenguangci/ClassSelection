package com.cgc.service;

import com.cgc.bean.Student;
import com.cgc.dao.StudentDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "studentService")
public class StudentService {
    private StudentDao studentDao = new StudentDao();
    public int studentNumber(String[] Info) {
        Student student = new Student();
        student.setStudentNo(Info[0]);
        student.setStudentName(Info[1]);
        student.setStudentSex(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())&&Info[3].matches("^\\d+$"))
            student.setStudentAge(Integer.parseInt(Info[3]));
        student.setDepartmentNo(Info[4]);
        return studentDao.studentNumber(student);
    }
    /**
     * 获取学生信息
     */
    @Cacheable(cacheNames = "selectStudent")
    public List<Student> selectStudents(String[] Info, int limit){
        Student student = new Student();
        student.setStudentNo(Info[0]);
        student.setStudentName(Info[1]);
        student.setStudentSex(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())&&Info[3].matches("^\\d+$"))
            student.setStudentAge(Integer.parseInt(Info[3]));
        student.setDepartmentNo(Info[4]);
        return studentDao.selectStudents(student,limit);
    }
    /**
     * 录入学生信息
     */
    public boolean insertStudents(String[][] Info){
        List<Student> students = new ArrayList<Student>();
        for (String [] info1:Info){
            Student student = new Student();
            student.setStudentNo(info1[0]);
            student.setStudentName(info1[1]);
            student.setStudentSex(info1[2]);
            if (info1[3]!=null&&!"".equals(info1[3].trim())&&info1[3].matches("^\\d+$"))
                student.setStudentAge(Integer.parseInt(info1[3]));
            else
                student.setStudentAge(null);
            student.setDepartmentNo(info1[4]);
            students.add(student);
        }
        return studentDao.insertStudents(students);
    }
    /**
     * 删除学生信息
     */
    public boolean deleteStudentsById(List<String> ids){
        return studentDao.deleteStudentsById(ids);
    }
    /**
     * 更改学生信息
     */
    public boolean updateStudent(String[] Info){
        Map<String,Object> student = new HashMap<String, Object>();
        student.put("studentNo",Info[0]);
        student.put("studentName",Info[1]);
        student.put("studentSex",Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim()))
            student.put("studentAge",Integer.parseInt(Info[3]));
        else
            student.put("studentAge",null);
        student.put("departmentNo",Info[4]);
        return studentDao.updateStudent(student);
    }
}
