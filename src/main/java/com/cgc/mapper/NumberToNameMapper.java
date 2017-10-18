package com.cgc.mapper;

import java.util.Map;

public interface NumberToNameMapper {
    Map<String,String> CourseNoToName();
    Map<String,String> DepartmentNoToName();
    Map<String,String> TeacherNoToName();
    Map<String,String> StudentNoToName();

}
