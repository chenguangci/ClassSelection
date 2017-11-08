package com.cgc.dao;

import com.cgc.bean.Department;
import com.cgc.db.DBAccess;
import com.cgc.mapper.DepartmentMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentDao {
    DBAccess dbAccess = new DBAccess();

    /**
     * 查询系信息
     */
    public List<Department> selectDepartment(Department department){
        List<Department> departments = new ArrayList<Department>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            departments = departmentMapper.selectDepartment(department);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
        return departments;
    }

    /**
     * 录入系信息
     */
    public boolean insertDepartments(List<Department> departments){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            departmentMapper.insertDepartments(departments);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }

    /**
     * 删除系信息
     */
    public boolean deleteDepartmentsById(List<String> ids){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            departmentMapper.deleteDepartmentsById(ids);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }

    /**
     * 更新系信息
     */
    public boolean updateDepartment(Map<String,Object> department){
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            departmentMapper.updateDepartment(department);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (sqlSession!=null){
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }
}
