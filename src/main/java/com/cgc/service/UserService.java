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
    public List<User> selectUser(String username, String role){
        int i;
        if (role == null || "".equals(role.trim())) {
            i = 0;
        } else {
            i = Integer.valueOf(role);
        }
        return userDao.selectUser(username, i);
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
        user.setUsername(info[0]);
        user.setPassword(info[1]);
        user.setRole(Integer.parseInt(info[2]));
        String name = info[0];
        return userDao.updateUser(user,name);
    }
    public boolean deleteUser(String name) {
        return userDao.deleteUser(name);
    }
}
