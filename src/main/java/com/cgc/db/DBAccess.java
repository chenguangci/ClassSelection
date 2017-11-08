package com.cgc.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 访问数据库，后期用spring代替，当前只做测试用
 */
public class DBAccess {
    private Reader reader;
    private SqlSessionFactory sqlSessionFactory;
    public DBAccess(){
        try {
            reader = Resources.getResourceAsReader("com/cgc/Configuration.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

    }
    public SqlSession getSqlSession() throws IOException{
        return sqlSessionFactory.openSession(true);
    }
}
