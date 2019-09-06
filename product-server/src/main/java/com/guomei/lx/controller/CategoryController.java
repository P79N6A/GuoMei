package com.guomei.lx.controller;

import com.guomei.pojo.Category;
import com.guomei.lx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Back/Category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //查询所有分类
    @RequestMapping("findCategory")
    public List<Map<String, Object>> findCategory() {

        return categoryService.findCategoryAndParentExist();
    }

    @RequestMapping("updateCategoryInfo/{cid}/{parentId}")
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

    @PostMapping("updateCategory")
    public String updateCategory(@RequestBody Category category) {
        int result = categoryService.updateCategoryInfo(category);
        if (result > 0) {
            String json = "{\"code\":\"success\"}";
            return json;
        }

        return "{\"msg\":\"更新失败\"}";
    }

    @RequestMapping("deleteCategory/{cid}")
    public String deleteCategory(@PathVariable("cid") Integer cid) {
        int result = categoryService.deleteCategory(cid);
        if (result > 0) {
            String json = "{\"code\":\"success\"}";
            return json;
        }
        return "{\"msg\":\"删除失败\"}";
    }

    @RequestMapping("brandExistGood/{cid}")
    public String brandExistGood(@PathVariable("cid") Integer cid) {
        int result = categoryService.brandExistGood(cid);
        String json;
        if (result > 0) {
            json = "{\"code\":\"exists\"}";
            return json;
        } else { //没有商品,可以删除
            int res = deleteBrand(cid);
            return "{\"code\":\"delBrand\"}";
        }

    }

    public int deleteBrand(Integer cid) {
        return categoryService.deleteBrand(cid);
    }

}
