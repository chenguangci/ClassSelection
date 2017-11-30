package com.cgc.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DownloadMapper {
    List<Map<String,Object>> select(@Param("table") String table, @Param("parameter") Map<String,Object> parameter);
}
