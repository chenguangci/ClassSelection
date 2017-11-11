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
    @Cacheable(cacheNames = "selectCourse")
    public List<Course> selectCourse(String[] dates) {
        Course course = new Course();
        /*为实体赋值*/
        course.setCourseNo(dates[0]);
        course.setCourseName(dates[1]);
        /*根据传递过来的课程名，找到对应的课程编号*/
        course.setCoursePriorNo(dates[2]);
        if (dates[3]!=null)
            course.setCourseCredit(Integer.parseInt(dates[3]));
        else
            course.setCourseCredit(null);
        return courseDao.selectCourse(course);
    }
    /**
     * 录入课表信息
     */
    public boolean insertCourses(String[][] dates) {

        List<Course> courses = new ArrayList<Course>();

        for (String[] date : dates){
            Course course = new Course();
            /*为实体赋值*/
            course.setCourseNo(date[0]);
            course.setCourseName(date[1]);
            course.setCoursePriorNo(getCourseNoByName(date[2]));
            if (date[3]!=null)
                course.setCourseCredit(Integer.parseInt(date[3]));
            else
                course.setCourseCredit(null);
            courses.add(course);
        }

        return courseDao.insertCourses(courses);
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
        course.put("coursePriorNo",dates[2]);
        if (dates[3]!=null)
            course.put("courseCredit",dates[3]);
        else
            course.put("courseCredit",null);
        return courseDao.updateCourse(course);
    }
}
