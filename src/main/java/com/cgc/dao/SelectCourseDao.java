package com.cgc.dao;

import com.cgc.bean.SelectCourse;
import com.cgc.db.DBAccess;
import com.cgc.mapper.SelectCourseMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectCourseDao {
    private DBAccess dbAccess = DBAccess.getInstance();
    public int selectNumber(SelectCourse selectCourse) {
        int number = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            number = selectCourseMapper.selectNumber(selectCourse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return number;
    }
    /**
     * 查询选课信息
     */
    public List<SelectCourse> selectSelectCourse(SelectCourse selectCourse, int limit) {
        List<SelectCourse> selectCourses = new ArrayList<SelectCourse>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourses = selectCourseMapper.selectSelectCourse(selectCourse, limit);
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
    public boolean insertSelectCourses(SelectCourse selectCourse) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourseMapper.insertSelectCourses(selectCourse);
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
     * 删除选课信息
     */
    public boolean deleteSelectCourses(SelectCourse selectCourse){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourseMapper.deleteSelectCourses(selectCourse);
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

    /**
     * 更新选课信息,没有主键可以标识，后面在修改
     */
    public boolean updateSelectCourse(SelectCourse selectCourse, String id){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            SelectCourseMapper selectCourseMapper = sqlSession.getMapper(SelectCourseMapper.class);
            selectCourseMapper.updateSelectCourse(selectCourse,id);
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
