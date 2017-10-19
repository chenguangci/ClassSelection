package com.cgc.mapper;

import com.cgc.bean.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {

    /*按条件查询*/
    List<Department> selectDepartment(Department department);
    /*录入系别信息*/
    void insertDepartments(List<Department> departments);
    /*删除系别信息*/
    void deleteDepartmentsById(List<Integer> ids);
    /*更新系别信息*/
    void updateDepartment(Map<String,Object> department);
}
