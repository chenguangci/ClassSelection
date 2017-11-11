package com.cgc.service;

import com.cgc.bean.Teacher;
import com.cgc.dao.TeacherDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "teacherService")
public class TeacherService {
    private TeacherDao teacherDao  = new TeacherDao();
    /**
     * 查询
     */
    @Cacheable(cacheNames = "selectTeacher")
    public List<Teacher> selectTeachers(String[] Info){
        Teacher teacher = new Teacher();
        teacher.setTeacherNo(Info[0]);
        teacher.setTeacherName(Info[1]);
        teacher.setTeacherSex(Info[2]);
        if (Info[3]!=null)
            teacher.setTeacherAge(Integer.parseInt(Info[3]));
        else
            teacher.setTeacherAge(null);
        teacher.setEducation(Info[4]);
        teacher.setProfessionalTitle(Info[5]);
        teacher.setCourseNo1(Info[6]);
        return teacherDao.selectTeachers(teacher);
    }
    /**
     * 插入
     */
    public boolean insertTeachers(String[][] Info){
        List<Teacher> teachers = new ArrayList<Teacher>();
        for (String[] info:Info){
            Teacher teacher = new Teacher();
            teacher.setTeacherNo(info[0]);
            teacher.setTeacherName(info[1]);
            teacher.setTeacherSex(info[2]);
            if (info[3]!=null)
                teacher.setTeacherAge(Integer.parseInt(info[3]));
            else
                teacher.setTeacherAge(null);
            teacher.setEducation(info[4]);
            teacher.setProfessionalTitle(info[5]);
            teacher.setCourseNo1(info[6]);
            teacher.setCourseNo2(info[7]);
            teacher.setCourseNo3(info[8]);
            teachers.add(teacher);
        }
        return teacherDao.insertTeachers(teachers);
    }
    /**
     * 删除
     */
    public boolean deleteTeachersById(List<String> ids){
        return teacherDao.deleteTeachersById(ids);
    }

    /**
     * 更新
     * @param Info 教师信息的参数集
     */
    public boolean updateTeacher(String[] Info){
        Map<String,Object> teacher = new HashMap<String,Object>();
        teacher.put("teacherNo",Info[0]);
        teacher.put("teacherName",Info[1]);
        teacher.put("teacherSex",Info[2]);
        if (Info[3]!=null)
            teacher.put("teacherAge",Integer.parseInt(Info[3]));
        else
            teacher.put("teacherAge",null);
        teacher.put("education",Info[4]);
        teacher.put("professionalTitle",Info[5]);
        teacher.put("courseNo1",Info[6]);
        teacher.put("courseNo2",Info[7]);
        teacher.put("courseNo3",Info[8]);
        return teacherDao.updateTeacher(teacher);
    }
}
