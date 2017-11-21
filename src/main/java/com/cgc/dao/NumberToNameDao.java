package com.cgc.dao;

import com.cgc.db.DBAccess;
import com.cgc.mapper.NumberToNameMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NumberToNameDao {
    private DBAccess dbAccess = DBAccess.getInstance();

    public Map<String,String> CourseNoToName(){
        Map<String,String> courses = new HashMap<String, String>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            NumberToNameMapper numberToNameMapper = sqlSession.getMapper(NumberToNameMapper.class);
            courses = numberToNameMapper.CourseNoToName();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return courses;
    }

    public Map<String,String> DepartmentNoToName(){
        Map<String,String> departments = new HashMap<String, String>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            NumberToNameMapper numberToNameMapper = sqlSession.getMapper(NumberToNameMapper.class);
            departments = numberToNameMapper.DepartmentNoToName();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return departments;
    }

    public Map<String,String> StudentNoToName(){
        Map<String,String> students = new HashMap<String, String>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            NumberToNameMapper numberToNameMapper = sqlSession.getMapper(NumberToNameMapper.class);
            students = numberToNameMapper.StudentNoToName();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return students;
    }

    public Map<String,String> TeacherNoToName(){
        Map<String,String> teachers = new HashMap<String, String>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            NumberToNameMapper numberToNameMapper = sqlSession.getMapper(NumberToNameMapper.class);
            teachers = numberToNameMapper.TeacherNoToName();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return teachers;
    }
}
