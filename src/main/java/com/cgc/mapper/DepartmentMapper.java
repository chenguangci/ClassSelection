package com.cgc.mapper;

import com.cgc.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    /*查询所有系别*/
    List<Department> selectAllDepartment();
    /*按条件查询*/
    List<Department> selectDepartment(Department department);
    /*录入系别信息*/
    void insertDepartments(List<Department> departments);
    /*删除系别信息*/
    void deleteDepartmentsById(List<Integer> ids);
    /*更新系别信息*/
    void updateDepartment(Department department);
}
