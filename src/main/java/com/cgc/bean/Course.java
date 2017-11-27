package com.cgc.bean;

import java.io.Serializable;

public class Course implements Serializable{
    private static final long serialVersionUID = 6320941908222932112L;
    private String courseNo;
    private String courseName;
    private String coursePriorNo;
    private String coursePriorName;
    private Integer courseCredit;

    public String getCoursePriorName() {
        return coursePriorName;
    }

    public void setCoursePriorName(String coursePriorName) {
        this.coursePriorName = coursePriorName;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePriorNo() {
        return coursePriorNo;
    }

    public void setCoursePriorNo(String coursePriorNo) {
        this.coursePriorNo = coursePriorNo;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }
}
