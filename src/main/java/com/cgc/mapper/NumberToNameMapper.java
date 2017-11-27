package com.cgc.mapper;

import java.util.List;
import java.util.Map;

public interface NumberToNameMapper {
    List<Map<String,String>> CourseNoToName();
    List<Map<String,String>> DepartmentNoToName();
    List<Map<String,String>> TeacherNoToName();
    List<Map<String,String>> StudentNoToName();

}
