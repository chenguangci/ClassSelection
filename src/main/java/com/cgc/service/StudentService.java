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
    public int[] insertStudents(String[][] Info){
        int[] total = new int[Info.length];
        for (int i=0; i<Info.length; i++){
            Student student = new Student();
            student.setStudentNo(Info[i][0]);
            student.setStudentName(Info[i][1]);
            student.setStudentSex(Info[i][2]);
            if (Info[i][3]!=null&&!"".equals(Info[i][3].trim())&&Info[i][3].matches("^\\d+$"))
                student.setStudentAge(Integer.parseInt(Info[i][3]));
            else
                student.setStudentAge(null);
            student.setDepartmentNo(Info[i][4]);
            if (studentDao.insertStudents(student)) {
                total[i] = 1;
            }
        }
        return total;
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
