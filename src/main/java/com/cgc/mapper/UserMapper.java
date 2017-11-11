package com.cgc.mapper;

import com.cgc.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    Integer checkUser(@Param("username")String username, @Param("password")String password);
    void insertUser(User user);
    void updateUser(@Param("user") User user,@Param("oldName") String name);
    void deleteUser(String oldName);
}
