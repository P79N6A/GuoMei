package com.guomei.service.impl;

import com.guomei.dao.GoodsDao;
import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Map<String, Object>> findGoods(Goods goods) {
        return goodsDao.findGoods(goods);
    }
}
