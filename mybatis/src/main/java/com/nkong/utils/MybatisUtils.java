package com.nkong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Author: nkong
 * @Date: 2020/6/10 22:32
 * @Version 1.0
 */
public class MybatisUtils {

    public static SqlSessionFactory sqlSessionFactory;
//    static {
//        try {
//            String resource = "tt.xml";
//            System.out.println("start");
//            InputStream inputStream = Resources.getResourceAsStream(resource);
//            System.out.println(inputStream.read());
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"utf8");
//            System.out.println(sqlSessionFactory);
//        } catch (Exception e) {
//            System.out.println("456");
//            System.out.println(e.getMessage());
//            System.out.println("123");
//            System.out.println(e);
//        }
//    }

    public static SqlSession getSqlSession() {
        try {
            String resource = "mybatis-config.xml";
            System.out.println("start");
            InputStream inputStream = Resources.getResourceAsStream(resource);
            System.out.println(inputStream.read());
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"utf8");
            System.out.println(sqlSessionFactory);
        } catch (Exception e) {
            System.out.println("456");
            System.out.println(e.getMessage());
            System.out.println("123");
            System.out.println(e);
        }
        return sqlSessionFactory.openSession();
    }

}
