package com.cgc.dao;

import com.cgc.db.DBAccess;
import com.cgc.mapper.NumberToNameMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumberToNameDao {
    private DBAccess dbAccess = DBAccess.getInstance();

    public List<Map<String,String>> CourseNoAndName(){
        List<Map<String,String>> courses = new ArrayList<Map<String,String>>();
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

    public List<Map<String,String>> DepartmentAndToName(){
        List<Map<String,String>> departments = new ArrayList<Map<String, String>>();
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

    public List<Map<String,String>> StudentNoAndName(){
        List<Map<String,String>> students = new ArrayList<Map<String, String>>();
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

    public List<Map<String,String>> TeacherNoAndName(){
        List<Map<String,String>> teachers = new ArrayList<Map<String, String>>();
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
