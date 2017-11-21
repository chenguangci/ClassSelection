package com.cgc.dao;

import com.cgc.bean.Student;
import com.cgc.db.DBAccess;
import com.cgc.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDao {
    private DBAccess dbAccess = DBAccess.getInstance();
    public int studentNumber(Student student) {
        SqlSession sqlSession = null;
        int number = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            number = studentMapper.studentNumber(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
    /**
     * 获取学生信息
     */
    public List<Student> selectStudents(Student student, int limit){
        List<Student> students = new ArrayList<Student>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            students = studentMapper.selectStudents(student,limit);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return students;
    }

    /**
     * 录入学生信息
     */
    public boolean insertStudents(List<Student> students){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudents(students);
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
     * 删除学生信息
     */
    public boolean deleteStudentsById(List<String> ids){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudentsById(ids);
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
     * 更改学生信息
     */
    public boolean updateStudent(Map<String,Object> student){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.updateStudent(student);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
