package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.pojo.PageInfo;
import com.guomei.service.GoodsService;
import lombok.val;
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

    //商品分类模块
    @RequestMapping("findCategory")
    public String findCategory() {
        String json = "{\"data\":" + goodsService.findCategory() + "}";
        return json;
    }

    @RequestMapping("updateCategoryInfo/{cid}/{parentId}")
    public String updateCategoryInfo(@PathVariable("cid") Integer cid, @PathVariable("parentId") Integer parentId) {
        return goodsService.updateCategoryInfo(cid, parentId);
    }

    @RequestMapping("updateCategory")
    public String updateCategory(@RequestParam Map<String, String> request) {
        //用于封装数据
        Category category = new Category();
        category.setCid(Integer.valueOf(request.get("cid")));
        category.setName(request.get("categoryName"));
        category.setParentId(Integer.valueOf(request.get("categoryList")));
        String json = "{\"res\":" + goodsService.updateCategory(category) + "}";
        return json;

    }

    @RequestMapping("deleteCategory/{cid}")
    public String deleteCategory(@PathVariable("cid") Integer cid) {
        String json =  goodsService.deleteCategory(cid);
        return json;
    }

    @RequestMapping("brandExistGood/{cid}")
    public String brandExistGood(@PathVariable("cid") Integer cid){
        String json =  goodsService.brandExistGood(cid);
        return json;
    }
    @RequestMapping("findTreeCategory/{cLevel}")
    public String findTreeCategory(@PathVariable("cLevel")Integer cLevel){
        return goodsService.findTreeCategory(cLevel);
    }

    @RequestMapping("addCategory")
    public String addCategory(@RequestParam Map<String, String> map){
        Category category = new Category();
        category.setName(map.get("parentName")+":"+map.get("categoryName"));
        return goodsService.addCategory(category);
    }



    //商品模块
    @RequestMapping("findGoods")
    public  Map<String, Object> findGoods(@RequestParam Map<String,Object> param){
        Map<String, Object> map = new HashMap<>();
        PageInfo<Map<String, Object>> goods = goodsService.findGoods(param);
        map.put("code",0);
        map.put("data",goods.getList());
        map.put("totalCount",goods.getTotalCount());
        return map;
    }

}
