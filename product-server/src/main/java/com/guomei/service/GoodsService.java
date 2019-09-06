package com.guomei.service;


import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    //查询所有商品
    List<Map<String,Object>> findGoods(Goods goods);
}
