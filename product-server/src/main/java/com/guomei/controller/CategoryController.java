package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.service.CategoryService;
import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Back/Category")
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //查询所有分类
    @RequestMapping("findCategory")
    @ResponseBody
    public List<Category> findCategory(){

        return categoryService.findCategory();
    }

    @RequestMapping("updateCategoryInfo/{cid}")
    @ResponseBody
    public Map<String,Object> updateCategoryInfo(@PathVariable("cid") Integer cid){
        Map<String,Object> map = new HashMap<>();
        Category category = null;
        return map;
    }
}
