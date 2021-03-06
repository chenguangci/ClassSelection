package com.cgc.dao;

import com.cgc.bean.Course;
import com.cgc.db.DBAccess;
import com.cgc.mapper.CourseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class CourseDao {
    private DBAccess dbAccess = DBAccess.getInstance();

    public int courseNumber(Course course) {
        SqlSession sqlSession = null;
        int number = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            number = courseMapper.courseNumber(course);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return number>0?(number-1):0;
    }
    /**
     * 查询课表信息
     */
    public List<Course> selectCourse(Course course, int limitNumber){
        List<Course> courses = new ArrayList<Course>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courses = courseMapper.selectCourse(course,limitNumber);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return courses;
    }

    /**
     * 录入课表信息
     */
    public boolean insertCourses(Course course){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.insertCourses(course);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 删除课表信息
     */
    public boolean deleteCoursesById(List<String> ids){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.deleteCoursesById(ids);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 更新课表信息
     */
    public boolean updateCourse(Map<String,Object> course){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.updateCourse(course);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
