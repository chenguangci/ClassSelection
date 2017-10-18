package com.cgc.dao;

import com.cgc.bean.Course;
import com.cgc.db.DBAccess;
import com.cgc.mapper.CourseMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    DBAccess dbAccess = new DBAccess();

    /**
     * 查询课表信息
     */
    public List<Course> selectCourse(Course course){
        List<Course> courses = new ArrayList<Course>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courses = courseMapper.selectCourse(course);
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
    public void insertCourses(List<Course> courses){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.insertCourses(courses);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 删除课表信息
     */
    public void delectCoursesById(List<Integer> ids){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.delectCoursesById(ids);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 更新课表信息
     */
    public void updateCourse(Course course){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            courseMapper.updateCourse(course);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
