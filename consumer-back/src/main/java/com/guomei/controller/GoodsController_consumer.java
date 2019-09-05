package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Goods")
@RestController
public class GoodsController_consumer {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("findCategory")
    public String findCategory(){
        String json ="{\"data\":"+goodsService.findCategory()+"}";
        return  json;
    }

    @RequestMapping("updateCategoryInfo/{cid}/{parentId}")
    public String updateCategoryInfo(@PathVariable("cid")Integer cid,@PathVariable("parentId") Integer parentId){

        return goodsService.updateCategoryInfo(cid,parentId);
    }

    @RequestMapping("updateCategory")
    public String updateCategory(@RequestParam Map<String,String> request){
        //用于封装数据
        Category category = new Category();
        category.setCid(Integer.valueOf(request.get("cid")));
        category.setName(request.get("categoryName"));
        category.setParentId(Integer.valueOf(request.get("categoryList")));
        String json ="{\"res\":"+goodsService.updateCategory(category)+"}";
        return json;

    }

}
