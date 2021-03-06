package com.guomei.lx.dao;

import com.guomei.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsDao {

    //查询所有商品
    List<Map<String,Object>> findGoods(Map<String,Object> map);

    //新增商品
    int addGoods(Map<String,Object> map);
}
