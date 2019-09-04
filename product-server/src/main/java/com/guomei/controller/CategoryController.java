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
    public List<Category> findCategory() {

        return categoryService.findCategory(null);
    }

    @RequestMapping("updateCategoryInfo/{cid}/{level}")
    @ResponseBody
    public Map<String, Object> updateCategoryInfo(@PathVariable("cid") Integer cid,@PathVariable("level") Integer level) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> param = new HashMap<>();//调用dao的参数
        Category category = categoryService.findCategoryParent(cid);
        if (category != null) { //表示当前分类有父分类
            map.put("parentCategory", category);
            //查询父分类同级别的分类信息
            param.put("level",level);
            //拿到和父分类同一级别的分类
            List<Category> parentBrother = categoryService.findCategory(param);
            map.put("parentBrother", parentBrother);
        } else {
            //没有父分类,表示为根栏目
            //返回当前分类
            param.put("cid", cid);
            List<Category> myCategory = categoryService.findCategory(param);
            map.put("myCategory", myCategory);
        }
        return map;
    }
}
