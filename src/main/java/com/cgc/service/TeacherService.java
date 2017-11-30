package com.cgc.service;

import com.cgc.bean.Teacher;
import com.cgc.dao.NumberToNameDao;
import com.cgc.dao.TeacherDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "teacherService")
public class TeacherService {
    private TeacherDao teacherDao  = new TeacherDao();
    public int teacherNumber(String[] Info) {
        Teacher teacher = new Teacher();
        teacher.setTeacherNo(Info[0]);
        teacher.setTeacherName(Info[1]);
        teacher.setTeacherSex(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())&&Info[3].matches("^\\d+$"))
            teacher.setTeacherAge(Integer.parseInt(Info[3]));
        else
            teacher.setTeacherAge(null);
        teacher.setEducation(Info[4]);
        teacher.setProfessionalTitle(Info[5]);
        teacher.setCourseNo1(Info[6]);
        return teacherDao.teacherNumber(teacher);
    }
    /**
     * 查询
     */
    @Cacheable(cacheNames = "selectTeacher")
    public List<Teacher> selectTeachers(String[] Info,int limit){
        Teacher teacher = new Teacher();
        teacher.setTeacherNo(Info[0]);
        teacher.setTeacherName(Info[1]);
        teacher.setTeacherSex(Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim())&&Info[3].matches("^\\d+$"))
            teacher.setTeacherAge(Integer.parseInt(Info[3]));
        else
            teacher.setTeacherAge(null);
        teacher.setEducation(Info[4]);
        teacher.setProfessionalTitle(Info[5]);
        teacher.setCourseNo1(Info[6]);

        //查找教师信息
        List<Teacher> teachers = teacherDao.selectTeachers(teacher,limit);

        //找出教师的授课编号对应的课程名
        NumberToNameDao dao = new NumberToNameDao();
        List<Map<String, String>> maps = dao.CourseNoAndName();
        Map<String, String> courses = new HashMap<String, String>();
        for (Map<String, String> map : maps) {
            courses.put(map.get("courseNo"), map.get("courseName"));
        }
        String str;
        for (Teacher teacher1 : teachers) {
            if (teacher1.getCourseNo1() != null || "0000".equals(teacher1.getCourseNo1())) {
                str = courses.get(teacher1.getCourseNo1());
                teacher1.setCourseName1(str==null?"":str);
            }
            if (teacher1.getCourseNo2() != null || "0000".equals(teacher1.getCourseNo2())) {
                str = courses.get(teacher1.getCourseNo2());
                teacher1.setCourseName2(str==null?"":str);
            }

            if (teacher1.getCourseNo3() != null || "0000".equals(teacher1.getCourseNo3())) {
                str = courses.get(teacher1.getCourseNo3());
                teacher1.setCourseName3(str==null?"":str);
            }
        }
        return teachers;
    }
    /**
     * 插入
     */
    public int[] insertTeachers(String[][] Info){
        int[] total = new int[Info.length];
        for (int i = 0; i<Info.length; i++){
            String[] info = Info[i];
            Teacher teacher = new Teacher();
            teacher.setTeacherNo(info[0]);
            teacher.setTeacherName(info[1]);
            teacher.setTeacherSex(info[2]);
            if (info[3]!=null&&!"".equals(info[3].trim())&&info[3].matches("^\\d+$"))
                teacher.setTeacherAge(Integer.parseInt(info[3]));
            else
                teacher.setTeacherAge(null);
            teacher.setEducation(info[4]);
            teacher.setProfessionalTitle(info[5]);
            if (info[6]==null || "".equals(info[6]))
                info[6] = "0000";
            if (info[7]==null || "".equals(info[7]))
                info[7] = "0000";
            if (info[8]==null || "".equals(info[8]))
                info[8] = "0000";
            teacher.setCourseNo1(info[6]);
            teacher.setCourseNo2(info[7]);
            teacher.setCourseNo3(info[8]);
            if (teacherDao.insertTeachers(teacher)){
                total[i] = 1;
            }
        }
        return total;
    }
    /**
     * 删除
     */
    public boolean deleteTeachersById(List<String> ids){
        return teacherDao.deleteTeachersById(ids);
    }

    /**
     * 更新
     * @param Info 教师信息的参数集
     */
    public boolean updateTeacher(String[] Info){
        Map<String,Object> teacher = new HashMap<String,Object>();
        teacher.put("teacherNo",Info[0]);
        teacher.put("teacherName",Info[1]);
        teacher.put("teacherSex",Info[2]);
        if (Info[3]!=null&&!"".equals(Info[3].trim()))
            teacher.put("teacherAge",Integer.parseInt(Info[3]));
        else
            teacher.put("teacherAge",null);
        teacher.put("education",Info[4]);
        teacher.put("professionalTitle",Info[5]);
        if (Info[6]==null || "".equals(Info[6]))
            Info[6] = "0000";
        if (Info[7]==null || "".equals(Info[7]))
            Info[7] = "0000";
        if (Info[8]==null || "".equals(Info[8]))
            Info[8] = "0000";
        teacher.put("courseNo1",Info[6]);
        teacher.put("courseNo2",Info[7]);
        teacher.put("courseNo3",Info[8]);
        return teacherDao.updateTeacher(teacher);
    }
}
