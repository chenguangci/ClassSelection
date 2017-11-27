package com.cgc.dao;

import com.cgc.db.DBAccess;
import com.cgc.mapper.DownloadMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Download {
    private DBAccess dbAccess = DBAccess.getInstance();
    public List<Map<String,Object>> select(String table) {
        List<Map<String,Object>> objects = null;
        try {
            SqlSession sqlSession = dbAccess.getSqlSession();
            DownloadMapper downloadMapper = sqlSession.getMapper(DownloadMapper.class);
            objects = downloadMapper.select(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
