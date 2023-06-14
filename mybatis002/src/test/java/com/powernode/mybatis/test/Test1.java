package com.powernode.mybatis.test;

import com.powernodemubatis.utils.SqlsessionUtil;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;

public class Test1 {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlsessionUtil.openSession();
        sqlSession.insert("insertCar");
        sqlSession.commit();
        sqlSession.close();
    }
}
