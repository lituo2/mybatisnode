package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(1011, "凯美瑞", 30.00, "2000-10-11", "新能源");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(14L);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(1011, "雅阁", 30.00, "2000-10-11", "新能源");
        int count = mapper.update(car);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(15L);
        System.out.println(car.toString());

    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        System.out.println(cars);
        System.out.println("-----");
        cars.forEach(car -> System.out.println(car));

    }

}
