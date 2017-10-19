package com.cgc.service;

import com.cgc.bean.Department;
import com.cgc.dao.DepartmentDao;

import java.util.List;
import java.util.Map;

public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();
    /**
     * 查询系信息
     */
    public List<Department> selectDepartment(Department department){
        return departmentDao.selectDepartment(department);
    }
    /**
     * 录入系信息
     */
    public void insertDepartments(List<Department> departments){
        departmentDao.insertDepartments(departments);
    }
    /**
     * 删除系信息
     */
    public void deleteDepartmentsById(List<Integer> ids){
        departmentDao.deleteDepartmentsById(ids);
    }
    /**
     * 更新系信息
     */
    public void updateDepartment(Map<String,Object> department){
        departmentDao.updateDepartment(department);
    }
}
