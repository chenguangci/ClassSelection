package com.cgc.service;

import com.cgc.bean.Course;
import com.cgc.dao.CourseDao;
import com.cgc.dao.NumberToNameDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "courseService")
public class CourseService {
    private CourseDao courseDao = new CourseDao();
    private List<Map<String,String>> maps;

    public int courseNumber(String[] info) {
        Course course = new Course();
        /*为实体赋值*/
        course.setCourseNo(info[0]);
        course.setCourseName(info[1]);
        course.setCoursePriorNo(info[2]);
        if (info[3]!=null&&!"".equals(info[3].trim())&&info[3].matches("^\\d+$"))
            course.setCourseCredit(Integer.parseInt(info[3]));
        else
            course.setCourseCredit(null);
        return courseDao.courseNumber(course);
    }
    /**
     * 获取编号和名称
     * @return 课程名对应的Number
     */
    public List<Map<String,String>> getCourseNoAndName() {
        NumberToNameDao numberToNameDao = new NumberToNameDao();
        if (maps == null)
            maps = numberToNameDao.CourseNoAndName();
        return maps;
    }
    /**
     * 查询课表信息
     */
    @Cacheable(cacheNames = "selectCourse")
    public List<Course> selectCourse(String[] dates, int limitNumber) {
        Course course = new Course();
        /*为实体赋值*/
        course.setCourseNo(dates[0]);
        course.setCourseName(dates[1]);
        if ("0000".equals(dates[2])){
            dates[2] = null;
        }
        course.setCoursePriorNo(dates[2]);
        if (dates[3]!=null&&!"".equals(dates[3].trim())&&dates[3].matches("^\\d+$"))
            course.setCourseCredit(Integer.parseInt(dates[3]));
        else
            course.setCourseCredit(null);
        return courseDao.selectCourse(course,limitNumber);
    }
    /**
     * 录入课表信息
     */
    public int[] insertCourses(String[][] dates) {
        int[] total = new int[dates.length];
        for (int i=0; i<dates.length; i++){
            String[] date = dates[i];
            Course course = new Course();
            /*为实体赋值*/
            course.setCourseNo(date[0]);
            course.setCourseName(date[1]);
            if (date[2]==null || "".equals(date[2].trim()))
                date[2] = "0000";
            course.setCoursePriorNo(date[2]);
            if (date[3]!=null&&!"".equals(date[3].trim())&&date[3].matches("^\\d+$"))
                course.setCourseCredit(Integer.parseInt(date[3]));
            else
                course.setCourseCredit(null);
            if (courseDao.insertCourses(course)){
                total[i] = 1;
            }
        }

        return total;
    }
    /**
     * 删除课表信息
     */
    public boolean deleteCoursesById(List<String> ids) {
        return courseDao.deleteCoursesById(ids);
    }
    /**
     * 更新课表信息
     */
    public boolean updateCourse(String[] dates) {
        Map<String,Object> course = new HashMap<String,Object>();
        course.put("courseNo",dates[0]);
        course.put("courseName",dates[1]);
        if (dates[2]==null || "".equals(dates[2].trim()))
            dates[2] = "0000";
        course.put("coursePriorNo",dates[2]);
        if (dates[3]!=null&&dates[3].matches("^\\d+$"))
            course.put("courseCredit",dates[3]);
        else
            course.put("courseCredit",null);
        return courseDao.updateCourse(course);
    }
}
