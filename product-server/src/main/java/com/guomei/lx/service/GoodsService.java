package com.guomei.lx.service;

import com.github.pagehelper.Page;
import com.guomei.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    //查询所有商品
    Page<Map<String,Object>> findGoods(Map<String,Object>map,int pageIndex,int pageSize);
}