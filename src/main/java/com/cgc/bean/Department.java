package com.cgc.bean;

import java.io.Serializable;

public class Department implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;
    private String departmentNo;
    private String departmentName;
    private String manager;

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
