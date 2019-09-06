package com.guomei.lx.controller;


import com.guomei.pojo.Goods;
import com.guomei.lx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Back/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("findGoods")
    private List<Map<String, Object>> findGoods(Goods goods) {
        return goodsService.findGoods(goods);
    }


}