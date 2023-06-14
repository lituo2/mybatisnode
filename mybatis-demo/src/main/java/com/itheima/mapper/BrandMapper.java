package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByCondition(@Param("statu") int statu, @Param("companyname") String company, @Param("brandname") String brandname);

    List<Brand> selectByCondition2(Brand brand);

    List<Brand> selectByCondition3(Map map);

    List<Brand> selectByCondition4(Map map);

    List<Brand> selectByConditionsingle(Brand brand);

    void add(Brand brand);

    void updateAll2(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int ids[]);

}
