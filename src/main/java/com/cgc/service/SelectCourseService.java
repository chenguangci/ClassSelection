package com.cgc.service;

import com.cgc.bean.SelectCourse;
import com.cgc.dao.SelectCourseDao;

import java.util.List;

public class SelectCourseService {
    private SelectCourseDao selectCourseDao = new SelectCourseDao();
    /**
     * 查询选课信息
     */
    public List<SelectCourse> selectSelectCourse(SelectCourse selectCourse){
        return selectCourseDao.selectSelectCourse(selectCourse);
    }
    /**
     * 录入选课信息
     */
    public void insertSelectCourses(List<SelectCourse> selectCourses){
        selectCourseDao.insertSelectCourses(selectCourses);
    }
    /**
     * 删除选课信息
     */
    public void deleteSelectCourses(List<SelectCourse> selectCourses){
        selectCourseDao.deleteSelectCourses(selectCourses);
    }
    /**
     * 更新选课信息,没有主键可以标识，后面在修改
     */
    public void updateSelectCourse(SelectCourse selectCourse){
        selectCourseDao.updateSelectCourse(selectCourse);
    }
}
