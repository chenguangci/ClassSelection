package com.cgc.service;

import com.cgc.bean.Department;
import com.cgc.dao.DepartmentDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "departmentService")
public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();
    public int departmentNumber(String[] Info) {
        Department department = new Department();
        department.setDepartmentNo(Info[0]);
        department.setDepartmentName(Info[1]);
        department.setManager(Info[2]);
        return departmentDao.departmentNumber(department);
    }
    /**
     * 查询系信息
     */
    @Cacheable(cacheNames = "selectDepartment")
    public List<Department> selectDepartment(String[] Info, int limit){
        Department department = new Department();
        department.setDepartmentNo(Info[0]);
        department.setDepartmentName(Info[1]);
        department.setManager(Info[2]);
        return departmentDao.selectDepartment(department, limit);
    }
    /**
     * 录入系信息
     */
    public int[] insertDepartments(String[][] Info){
        int[] total = new int[Info.length];
        for (int i=0; i< Info.length; i++){
            Department department = new Department();
            department.setDepartmentNo(Info[i][0]);
            department.setDepartmentName(Info[i][1]);
            department.setManager(Info[i][2]);
            if (departmentDao.insertDepartments(department)){
                total[i] = 1;
            }
        }
        return total;
    }
    /**
     * 删除系信息
     */
    public boolean deleteDepartmentsById(List<String> ids){
        return departmentDao.deleteDepartmentsById(ids);
    }
    /**
     * 更新系信息
     */
    public boolean updateDepartment(String[] Info){
        Map<String,Object> department = new HashMap<String,Object>();
        department.put("departmentNo",Info[0]);
        department.put("departmentName",Info[1]);
        department.put("manager",Info[2]);
        return departmentDao.updateDepartment(department);
    }
}
