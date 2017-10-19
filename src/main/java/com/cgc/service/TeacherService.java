package com.cgc.service;

import com.cgc.bean.Teacher;
import com.cgc.dao.TeacherDao;

import java.util.List;
import java.util.Map;

public class TeacherService {
    private TeacherDao teacherDao  = new TeacherDao();
    /**
     * 查询
     */
    public List<Teacher> selectTeachers(Teacher teacher){

        return teacherDao.selectTeachers(teacher);
    }
    /**
     * 插入
     */
    public void insertTeachers(List<Teacher> teachers){
        teacherDao.insertTeachers(teachers);
    }
    /**
     * 删除
     */
    public void deleteTeachersById(List<Integer> ids){
        teacherDao.deleteTeachersById(ids);
    }

    /**
     * 更新
     */
    public void updateTeacher(Map<String,Object> teacher){
        teacherDao.updateTeacher(teacher);
    }
}
