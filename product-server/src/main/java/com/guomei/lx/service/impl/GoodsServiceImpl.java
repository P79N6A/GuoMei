package com.guomei.lx.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guomei.lx.dao.GoodsDao;
import com.guomei.pojo.Goods;
import com.guomei.lx.service.GoodsService;
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
    public Page<Map<String, Object>> findGoods(Map<String, Object> map, int pageIndex, int pageSize) {
        Page<Map<String, Object>> page = PageHelper.startPage(pageIndex, pageSize);
        goodsDao.findGoods(map);
        return page;
    }
}
