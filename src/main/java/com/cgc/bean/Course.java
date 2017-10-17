package com.cgc.bean;

public class Course {
    private String courseNo;
    private String courseName;
    private String coursePriorNo;
    private Integer courseCredit;

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
