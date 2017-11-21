package com.cgc.bean;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;
    private String username;
    private String password;
    private Integer role = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
