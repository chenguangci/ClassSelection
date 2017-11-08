package com.cgc.service;

import com.cgc.bean.SelectCourse;
import com.cgc.dao.SelectCourseDao;

import java.util.ArrayList;
import java.util.List;

public class SelectCourseService {
    private SelectCourseDao selectCourseDao = new SelectCourseDao();
    /**
     * 查询选课信息
     */
    public List<SelectCourse> selectSelectCourse(String[] Info){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(Info[0]);
        selectCourse.setCourseNo(Info[1]);
        selectCourse.setTeacherNo(Info[2]);
        if (Info[3]!=null) {
            selectCourse.setGrade(Integer.parseInt(Info[3]));
        } else {
            selectCourse.setGrade(null);
        }
        return selectCourseDao.selectSelectCourse(selectCourse);
    }
    /**
     * 录入选课信息
     */
    public boolean insertSelectCourses(String[][] Info){
        List<SelectCourse> selectCourses = new ArrayList<SelectCourse>();
        for (String[] info:Info){
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setStudentNo(info[0]);
            selectCourse.setCourseNo(info[1]);
            selectCourse.setTeacherNo(info[2]);
            if (info[3]!=null){
                selectCourse.setGrade(Integer.parseInt(info[3]));
            } else {
                selectCourse.setGrade(null);
            }
        }
        return selectCourseDao.insertSelectCourses(selectCourses);
    }
    /**
     * 删除选课信息
     */
    public boolean deleteSelectCourses(String[][] Info){
        List<SelectCourse> selectCourses = new ArrayList<SelectCourse>();
        for (String[] info:Info) {
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setStudentNo(info[0]);
            selectCourse.setCourseNo(info[1]);
            selectCourse.setTeacherNo(info[2]);
        }
        return selectCourseDao.deleteSelectCourses(selectCourses);
    }
    /**
     * 更新选课信息,以
     */
    public boolean updateSelectCourse(String[] Info){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(Info[0]);
        selectCourse.setCourseNo(Info[1]);
        selectCourse.setTeacherNo(Info[2]);
        if (Info[3]!=null) {
            selectCourse.setGrade(Integer.parseInt(Info[3]));
        } else {
            selectCourse.setGrade(null);
        }
        return selectCourseDao.updateSelectCourse(selectCourse);
    }
}
