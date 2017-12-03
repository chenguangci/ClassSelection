package com.cgc.dao;

import com.cgc.bean.User;
import com.cgc.db.DBAccess;
import com.cgc.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private DBAccess dbAccess = DBAccess.getInstance();
    public List<User> selectUser(String username, int role) {
        List<User> users = new ArrayList<User>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            users = userMapper.selectUser(username, role);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return users;
    }

    public Integer checkUser( String username, String password){
        Integer role = null;
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            role = userMapper.checkUser(username,password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
        return role;
    }

    public boolean insertUser(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }

    }

    public boolean updateUser(User user, String name) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(user, name);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }

    }

    public boolean deleteUser(String oldName) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(oldName);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null)
                sqlSession.close();
        }
    }
}
