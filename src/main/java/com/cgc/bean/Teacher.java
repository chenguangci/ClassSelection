package com.cgc.bean;

import java.io.Serializable;

public class Teacher implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;
    private String teacherNo;
    private String teacherName;
    private String teacherSex;
    private Integer teacherAge;
    private String education;
    private String professionalTitle;
    private String courseNo1;
    private String courseNo2;
    private String courseNo3;
    private String courseName1;
    private String courseName2;
    private String courseName3;

    public String getCourseName1() {
        return courseName1;
    }

    public void setCourseName1(String courseName1) {
        this.courseName1 = courseName1;
    }

    public String getCourseName2() {
        return courseName2;
    }

    public void setCourseName2(String courseName2) {
        this.courseName2 = courseName2;
    }

    public String getCourseName3() {
        return courseName3;
    }

    public void setCourseName3(String courseName3) {
        this.courseName3 = courseName3;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getCourseNo1() {
        return courseNo1;
    }

    public void setCourseNo1(String courseNo1) {
        this.courseNo1 = courseNo1;
    }

    public String getCourseNo2() {
        return courseNo2;
    }

    public void setCourseNo2(String courseNo2) {
        this.courseNo2 = courseNo2;
    }

    public String getCourseNo3() {
        return courseNo3;
    }

    public void setCourseNo3(String courseNo3) {
        this.courseNo3 = courseNo3;
    }
}
