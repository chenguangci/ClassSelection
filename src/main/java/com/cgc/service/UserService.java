package com.cgc.service;

import com.cgc.bean.User;
import com.cgc.dao.UserDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userService")
public class UserService {
    private UserDao userDao = new UserDao();
    @Cacheable(cacheNames = "selectUser")
    public List<User> selectUser(){
        return userDao.selectUser();
    }

    public Integer checkUser(String name,String password) {
        return userDao.checkUser(name,password);
    }

    public boolean insertUser(String[] info){
        User user = new User();
        user.setUsername(info[0]);
        user.setPassword(info[1]);
        user.setRole(Integer.parseInt(info[2]));
        return userDao.insertUser(user);
    }
    public boolean updateUser(String[] info){
        User user = new User();
        user.setUsername(info[1]);
        user.setPassword(info[2]);
        user.setRole(Integer.parseInt(info[3]));
        String name = info[0];
        return userDao.updateUser(user,name);
    }
    public boolean deleteUser(String name) {
        return userDao.deleteUser(name);
    }
}
