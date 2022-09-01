package com.kaykayking.mybatis;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 3:24 下午 2022/8/2.
 * @Modified By:
 */

import com.kaykayking.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

/**
 * todo
 *
 * @author hk
 * @version Id: TestMybatis.java, v 0.1 2022/8/2 3:24 下午 Exp $$
 */
@SpringBootTest
public class TestMybatis {


    @Test
    public void testSelectAll() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);

       SqlSession sqlSession = sessionFactory.openSession();

       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(userMapper.selectAll());


    }


    @Test
    public void testGetUserByName() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(userMapper.getUserByUsername("John"));


    }

}