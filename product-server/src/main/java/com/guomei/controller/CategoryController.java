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

    @RequestMapping("updateCategoryInfo/{cid}/{parentId}")
    @ResponseBody
    public Map<String, Object> updateCategoryInfo(@PathVariable("cid") Integer cid, @PathVariable("parentId") Integer parentId) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> param = new HashMap<>();//调用dao的参数
        //查询当前分类相关信息
        param.put("cid", cid);
        List<Category> myCategory = categoryService.findCategory(param);
        map.put("myCategory", myCategory.get(0));
        //查询当前分类是否有父分类
        Category category = categoryService.findCategoryParent(parentId);
        if (category != null) {
            param.remove("cid");//清空
            map.put("parentCategory", category);
            param.put("level", category.getCLevel());
            //查询父分类同级别的分类信息
            List<Category> parentBrother = categoryService.findCategory(param);
            map.put("parentBrother", parentBrother);
        } else
            map.put("flag", "myRoot");
        return map;
    }
}
