package com.guomei.controller;

import com.guomei.pojo.Goods;
import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("Back/Goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("list")
    @ResponseBody
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

}
