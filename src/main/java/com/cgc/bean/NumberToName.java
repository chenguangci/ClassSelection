package com.cgc.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * 用于将各表的属性编号与属性名称对应起来
 */
public class NumberToName implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;
    private Map<String,String> CourseNoToName;
    private Map<String,String> DepartmentNoToName;
    private Map<String,String> TeacherNoToName;
    private Map<String,String> StudentNoToName;

    public Map<String, String> getDepartmentNoToName() {
        return DepartmentNoToName;
    }

    public void setDepartmentNoToName(Map<String, String> departmentNoToName) {
        DepartmentNoToName = departmentNoToName;
    }

    public Map<String, String> getTeacherNoToName() {
        return TeacherNoToName;
    }

    public void setTeacherNoToName(Map<String, String> teacherNoToName) {
        TeacherNoToName = teacherNoToName;
    }

    public Map<String, String> getStudentNoToName() {
        return StudentNoToName;
    }

    public void setStudentNoToName(Map<String, String> studentNoToName) {
        StudentNoToName = studentNoToName;
    }

    public Map<String, String> getCourseNoToName() {
        return CourseNoToName;
    }

    public void setCourseNoToName(Map<String, String> courseNoToName) {
        CourseNoToName = courseNoToName;
    }
}
