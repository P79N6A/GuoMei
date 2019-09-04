package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Back/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("findCategory")
    @ResponseBody
    public List<Category> findCategory(){

        return goodsService.findCategory();
    }




}
