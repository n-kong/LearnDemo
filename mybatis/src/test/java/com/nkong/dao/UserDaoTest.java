package com.nkong.dao;

import com.nkong.bean.User;
import com.nkong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: nkong
 * @Date: 2020/6/10 22:58
 * @Version 1.0
 */
public class UserDaoTest {

    @Test
    public void test() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }

}
