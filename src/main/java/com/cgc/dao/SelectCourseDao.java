package com.cgc.dao;

import com.cgc.bean.SelectCourse;
import com.cgc.db.DBAccess;
import com.cgc.mapper.SelectCourseMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectCourseDao {
    DBAccess dbAccess = new DBAccess();
    /**
     * 查询选课信息
     */
    public List<SelectCourse> selectSelectCourse(SelectCourse selectCourse) {
        List<SelectCourse> selectCourses = new ArrayList<SelectCourse>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourses = selectCourseMapper.selectSelectCourse(selectCourse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return selectCourses;
    }

    /**
     * 录入选课信息
     */
    public void insertSelectCourses(List<SelectCourse> selectCourses) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourseMapper.insertSelectCourses(selectCourses);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 删除选课信息
     */
    public void deleteSelectCourses(List<SelectCourse> selectCourses){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourseMapper.deleteSelectCourses(selectCourses);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 更新选课信息,没有主键可以标识，后面在修改
     */
    public void updateSelectCourse(SelectCourse selectCourse){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourseMapper.updateSelectCourse(selectCourse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
