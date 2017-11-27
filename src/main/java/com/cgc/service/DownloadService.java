package com.cgc.service;

import com.cgc.dao.Download;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DownloadService {

    private HSSFWorkbook workbook = new HSSFWorkbook();

    public HSSFWorkbook select(String type){
        Download download = new Download();
        List<String[]> model = new ArrayList<String[]>();
        List<Map<String,Object>> objects = download.select(type);

        if ("course".equals(type)) {
            for (Map<String,Object> object:objects) {
                String[] course = new String[4];
                course[0] =(String) object.get("courseNo");
                course[1] =(String) object.get("courseName");
                course[2] =(String) object.get("coursePriorNo");
                course[3] = (object.get("courseCredit")).toString();
                model.add(course);
            }
            String name = "课程信息表";
            String[] title = {"课程编号","课程名称","先修课程","学分"};
            createExcel(name,title,model);
        } else if ("department".equals(type)) {
            for (Map<String,Object> object:objects) {
                String[] department = new String[3];
                department[0] = (String) object.get("departmentNo");
                department[1] = (String) object.get("departmentName");
                department[2] = (String) object.get("manager");
                model.add(department);
            }
            String name = "院系信息表";
            String[] title = {"院系编号","院系名称","院系主任"};
            createExcel(name,title,model);

        } else if ("selectcourse".equals(type)) {
            for (Map<String,Object> object:objects) {
                String[] selectCourse = new String[4];
                selectCourse[0] = (String) object.get("studentNo");
                selectCourse[1] = (String) object.get("courseNo");
                selectCourse[2] = (String) object.get("teacherNo");
                selectCourse[3] = (object.get("grade")).toString();
                model.add(selectCourse);
            }
            String name = "选课信息表";
            String[] title = {"学生姓名","课程名称","教师姓名","成绩"};
            createExcel(name,title,model);

        } else if ("student".equals(type)) {
            for (Map<String,Object> object:objects) {
                String[] student = new String[5];
                student[0] = (String) object.get("studentNo");
                student[1] = (String) object.get("studentName");
                student[2] = (String) object.get("studentSex");
                student[3] = (object.get("studentAge")).toString();
                student[4] = (String) object.get("departmentNo");
                model.add(student);
            }
            String name = "学生信息表";
            String[] title = {"学号","姓名","性别","年龄","院系"};
            createExcel(name,title,model);

        } else if ("teacher".equals(type)) {
            for (Map<String,Object> object:objects) {
                String[] teacher = new String[9];
                teacher[0] = (String) object.get("teacherNo");
                teacher[1] = (String) object.get("teacherName");
                teacher[2] = (String) object.get("teacherSex");
                teacher[3] = (object.get("teacherAge")).toString();
                teacher[4] = (String) object.get("education");
                teacher[5] = (String) object.get("professionalTitle");
                teacher[6] = (String) object.get("courseNo1");
                teacher[7] = (String) object.get("courseNo2");
                teacher[8] = (String) object.get("courseNo3");
                model.add(teacher);
            }
            String name = "教师信息表";
            String[] title = {"教师编号","姓名","性别","年龄","学历","职称","授课1","授课2","授课3"};
            createExcel(name,title,model);
        }
        return workbook;
    }

    private void createExcel(String name, String[] titles, List<String[]> models) {
        HSSFSheet sheet = workbook.createSheet(name);
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell;
        for (int i=0; i<titles.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(style);
        }
        for (int i=1; i<models.size(); i++) {
            row = sheet.createRow(i);
            String[] model = models.get(i-1);
            for (int j=0; j<model.length; j++) {
                row.createCell(j).setCellValue(model[j]);
            }
        }
    }
}
