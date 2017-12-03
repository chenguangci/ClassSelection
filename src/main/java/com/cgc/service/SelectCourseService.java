package com.cgc.service;

import com.cgc.bean.SelectCourse;
import com.cgc.dao.SelectCourseDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "selectCourseService")
public class SelectCourseService {
    private SelectCourseDao selectCourseDao = new SelectCourseDao();
    public int selectNumber(String[] Info) {
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(Info[0]);
        selectCourse.setCourseNo(Info[1]);
        selectCourse.setTeacherNo(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())) {
            selectCourse.setGrade(Integer.parseInt(Info[3]));
        } else {
            selectCourse.setGrade(null);
        }
        return selectCourseDao.selectNumber(selectCourse);
    }
    /**
     * 查询选课信息
     */
    @Cacheable(cacheNames = "selectSelectCourse")
    public List<SelectCourse> selectSelectCourse(String[] Info,int limit){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(Info[0]);
        selectCourse.setCourseNo(Info[1]);
        selectCourse.setTeacherNo(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())) {
            selectCourse.setGrade(Integer.parseInt(Info[3]));
        } else {
            selectCourse.setGrade(null);
        }
        return selectCourseDao.selectSelectCourse(selectCourse,limit);
    }
    /**
     * 录入选课信息
     */
    public int[] insertSelectCourses(String[][] Info){
        int[] total = new int[Info.length];
        for (int i=0; i<Info.length; i++){
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setStudentNo(Info[i][0]);
            selectCourse.setCourseNo(Info[i][1]);
            selectCourse.setTeacherNo(Info[i][2]);
            if (Info[i][3]!=null&&!"".equals(Info[i][3].trim())){
                selectCourse.setGrade(Integer.parseInt(Info[i][3]));
            } else {
                selectCourse.setGrade(null);
            }
            if (selectCourseDao.insertSelectCourses(selectCourse)) {
                total[i] = 1;
            }
        }
        return total;
    }
    /**
     * 删除选课信息
     */
    public boolean deleteSelectCourses(String[] info){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(info[0]);
        selectCourse.setCourseNo(info[1]);
        selectCourse.setTeacherNo(info[2]);
        return selectCourseDao.deleteSelectCourses(selectCourse);
    }
    /**
     * 更新选课信息
     */
    public boolean updateSelectCourse(String[] Info,String id){
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setStudentNo(Info[0]);
        selectCourse.setCourseNo(Info[1]);
        selectCourse.setTeacherNo(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())) {
            selectCourse.setGrade(Integer.parseInt(Info[3]));
        } else {
            selectCourse.setGrade(null);
        }
        return selectCourseDao.updateSelectCourse(selectCourse,id);
    }
}
