package com.itheimatest;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void selectAllTest() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        brands.forEach(brand -> System.out.println(brand));
        sqlSession.close();

    }

    @Test
    public void selectByIdTest() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand1 = mapper.selectById(1);
        System.out.println(brand1);
        sqlSession.close();

    }

    @Test
    public void selectByConditionTest() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(0, "三只松鼠", "三只松鼠");
        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void selectByConditionTest2() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand(4, "三只松鼠", "三只松鼠", 30, "又好吃还不上火哦", 0);
        List<Brand> brands = mapper.selectByCondition2(brand);
        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void selectByConditionTest3() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("k1", 0);
        map.put("k2", "三只松鼠");
        map.put("k3", "三只松鼠");
        List<Brand> brands = mapper.selectByCondition3(map);
        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void selectByConditionTest4() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Map<String, Object> map = new HashMap<>();
        //map.put("statu",0);
        map.put("companyname", "三只松鼠");
        //map.put("brandname","三只松鼠");
        List<Brand> brands = mapper.selectByCondition4(map);
        brands.forEach(brand -> System.out.println(brand));
        sqlSession.close();

    }

    @Test
    public void selectByConditionsingle() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand(4, "三只松鼠", null, 30, "又好吃还不上火哦", null);
        List<Brand> brands = mapper.selectByConditionsingle(brand);
        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void add() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setOrdered(70);
        brand.setBrandname("七只松鼠");
        brand.setCompanyname("七只松鼠");
        brand.setDescription("你妈的");
        brand.setStatu(1);
        mapper.add(brand);
        System.out.println(brand.getId());
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void update() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setId(7);
        //brand.setOrdered(90);
        //brand.setBrandname("七只松鼠!");
        //brand.setCompanyname("七只松鼠!");
        brand.setDescription("你妈的!!!");
        //brand.setStatu(0);
        mapper.updateAll2(brand);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteById() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(7);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteByIds() throws IOException {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int ids[] = {3, 6};
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();

    }
}
