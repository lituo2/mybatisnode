package com.powernode.mybatis.test;

import com.powernodemubatis.utils.SqlsessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ConfigurationTest {

    @Test
    public void testEnvierment() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"), "development");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> cars = sqlSession.selectList("selectCar2");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();

    }

    @Test
    public void testEnvirment2() throws IOException {
        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession2 = sqlSessionFactory1.openSession();
        List<Object> cars2 = sqlSession2.selectList("selectCar2");
        cars2.forEach(car -> System.out.println(car));
        sqlSession2.close();
    }

    @Test
    public void testDataSource() throws IOException {
        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        sqlSession1.selectList("selectCar2");
        sqlSession1.commit();
        sqlSession1.close();

        System.out.println("****************");

        SqlSession sqlSession2 = sqlSessionFactory1.openSession();
        sqlSession2.selectList("selectCar2");
        sqlSession2.commit();
        sqlSession2.close();
    }

    @Test
    public void testDataSource2() throws IOException {
        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession = sqlSessionFactory1.openSession();
            sqlSession.selectList("selectCar2");
            System.out.println("*******************");
        }

    }
}
