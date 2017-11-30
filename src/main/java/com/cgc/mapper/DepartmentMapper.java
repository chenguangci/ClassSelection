package com.cgc.mapper;

import com.cgc.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {
    int departmentNumber(@Param("department") Department department);
    /*按条件查询*/
    List<Department> selectDepartment(@Param("department") Department department, @Param("limit") int limit);
    /*录入系别信息*/
    void insertDepartments(Department department);
    /*删除系别信息*/
    void deleteDepartmentsById(List<String> ids);
    /*更新系别信息*/
    void updateDepartment(Map<String,Object> department);
}
