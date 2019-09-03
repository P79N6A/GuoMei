package com.guomei.dao;

import com.guomei.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select * from goods")
    List<Goods> findAll();

}
