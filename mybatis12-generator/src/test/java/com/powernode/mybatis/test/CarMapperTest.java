package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.CarExample;
import com.powernode.mybatis.utils.SqlsessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {
    @Test
    public void testDeleteByPrimaryKey() {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByPrimaryKey(1002L);
        System.out.println(car);
        CarExample carExample = new CarExample();
        carExample.createCriteria().andBrandEqualTo("111");
        mapper.selectByExample(carExample);

        sqlSession.close();

    }

}
