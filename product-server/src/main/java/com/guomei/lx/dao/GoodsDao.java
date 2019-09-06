package com.guomei.lx.dao;

import com.guomei.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsDao {

    //查询所有商品
    List<Map<String,Object>> findGoods(Goods goods);
}
