package com.cgc.service;

import com.cgc.bean.Course;
import com.cgc.dao.CourseDao;
import com.cgc.dao.NumberToNameDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService {
    private CourseDao courseDao = new CourseDao();
    private Map<String,String> maps;

    /**
     * 获取编号和名称
     * @param name 课程名
     * @return 课程名对应的Number
     */
    private String getCourseNoByName(String name) {
        if (name == null)
            return null;
        NumberToNameDao numberToNameDao = new NumberToNameDao();
        String number = null;
        if (maps != null) {
            for (Map.Entry<String,String> entry : maps.entrySet()){
                if (name.equals(entry.getValue())){
                    number = entry.getKey();
                    break;
                }
            }
        } else {
            maps = numberToNameDao.CourseNoToName();
            for (Map.Entry<String,String> entry : maps.entrySet()){
                if (name.equals(entry.getValue())){
                    number = entry.getKey();
                    break;
                }
            }
        }
        return number;
    }
    /**
     * 查询课表信息
     */
    public List<Course> selectCourse(Object[] dates) {
        Course course = new Course();
        /*为实体赋值*/
        course.setCourseNo((String)dates[0]);
        course.setCourseName((String)dates[1]);
        /*根据传递过来的课程名，找到对应的课程编号*/
        course.setCoursePriorNo(getCourseNoByName((String)dates[2]));
        course.setCourseCredit((Integer)dates[3]);
        return courseDao.selectCourse(course);
    }
    /**
     * 录入课表信息
     */
    public void insertCourses(Object[][] dates) {

        List<Course> courses = new ArrayList<Course>();

        for (Object[] date : dates){
            Course course = new Course();
            /*为实体赋值*/
            course.setCourseNo((String)date[0]);
            course.setCourseName((String)date[1]);
        /*根据传递过来的课程名，找到对应的课程编号*/
            course.setCoursePriorNo(getCourseNoByName((String)date[2]));
            course.setCourseCredit((Integer)date[3]);
            System.out.println(course.getCourseNo()+" "+course.getCourseName()+" "+course.getCourseCredit());
            courses.add(course);
        }

        courseDao.insertCourses(courses);
    }
    /**
     * 删除课表信息
     */
    public void deleteCoursesById(String[] dates) {
        List<String> ids = new ArrayList<String>();
        for (String date : dates){
            ids.add(date);
        }
        courseDao.deleteCoursesById(ids);
    }
    /**
     * 更新课表信息
     */
    public void updateCourse(Object[] dates) {
        Map<String,Object> course = new HashMap<String,Object>();
        course.put("courseNo",dates[0]);
        course.put("courseName",dates[1]);
        course.put("coursePriorNo",dates[2]);
        course.put("courseCredit",dates[3]);
        courseDao.updateCourse(course);
    }
}
