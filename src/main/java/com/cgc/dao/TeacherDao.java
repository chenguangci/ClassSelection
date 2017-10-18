package com.cgc.dao;

import com.cgc.bean.Teacher;
import com.cgc.db.DBAccess;
import com.cgc.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    private static DBAccess dbAccess = new DBAccess();
    /**
     * 获取教师信息
     */
    public List<Teacher> selectTeachers(Teacher teacher){
        List<Teacher> teachers = new ArrayList<Teacher>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            teachers = teacherMapper.selectTeachers(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return teachers;
    }

    /**
     * 录入教师信息
     */
    public void insertTeachers(List<Teacher> teachers){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            teacherMapper.insertTeachers(teachers);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 删除学生信息
     */
    public void deleteTeachersById(List<Integer> ids){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            teacherMapper.deleteTeachersById(ids);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    /**
     * 更新学生信息
     */
    public void updateTeacher(Teacher teacher){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            teacherMapper.updateTeacher(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
