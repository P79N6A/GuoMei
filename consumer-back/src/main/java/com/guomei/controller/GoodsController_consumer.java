package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Goods")
@Controller
public class GoodsController_consumer {

    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("findCategory")
    public String findCategory(){
        String json ="{\"data\":"+goodsService.findCategory()+"}";
        return  json;
    }

    @RequestMapping("updateCategoryInfo/{cid}/{parentId}")
    @ResponseBody
    public String updateCategoryInfo(@PathVariable("cid")Integer cid,@PathVariable("parentId") Integer parentId){

        return goodsService.updateCategoryInfo(cid,parentId);
    }

}
