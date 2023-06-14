package com.powernode.mybatis.test;

import com.powernodemubatis.domain.Car;
import com.powernodemubatis.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    public void testInsertCar() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("k1", "1014");
        map.put("k2", "qq");
        map.put("k3", "6.00");
        map.put("k4", "2023-11-11");
        map.put("k5", "油车");

        SqlSession sqlSession = SqlsessionUtil.openSession();
        sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelCar() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        sqlSession.insert("delCar", 14);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void UpdateCar() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        sqlSession.insert("updateCar", 3);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void UpdateCar2() {
        Car car = new Car(1002, "奔驰E300L", null, null, null);

        SqlSession sqlSession = SqlsessionUtil.openSession();
        sqlSession.insert("updateCar2", car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void SelectCar() {
        SqlSession sqlSession = SqlsessionUtil.openSession();

        Car o = (Car) sqlSession.selectOne("selectCar", 1);
        //System.out.println(o.getCar_num() + o.getBrand() + o.getCar_tyoe() + o.getGuide_price() + o.getProduce_time());
        System.out.println("*******************");
        System.out.println(o);
        sqlSession.close();
    }

    @Test
    public void SelectCar2() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("aaa1.selectCar2");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    //用来看核心配置文件namespace的作用
    @Test
    public void SelectCar3() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("aaa2.selectCar2");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
