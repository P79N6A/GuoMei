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

    @RequestMapping("findTreeCategory/{cLevel}")
    public List<Map<String, Object>> findTreeCategory(@PathVariable("cLevel") Integer cLevel) {
        List<Map<String, Object>> list = categoryService.findTreeCategory(cLevel);
        if(cLevel!=5){
            Map<String,Object> map = new HashMap<>();
            map.put("name","根栏目");
            map.put("pid","0");
            map.put("id","-1");
            list.add(map);
        }
        return list;
    }

    @RequestMapping("addCategory")
    public String addCategory(@RequestBody Category category){
        System.out.println("category = " + category);
        String [] name = category.getName().split(":");
        String parentName = name[0];
        String newName = name[1];
        Category category2 = new Category();
        if("根栏目".equals(parentName)){
            category2.setName(newName);
            category2.setParentId(0);
            category2.setCLevel(1);
        }else{
            Map<String,Object> param = new HashMap<>();
            param.put("name",parentName);
            List<Category> parentBrother = categoryService.findCategory(param);
            if(parentBrother.get(0)!=null){
                category2.setName(newName);
                category2.setParentId(parentBrother.get(0).getCid());
                category2.setCLevel(parentBrother.get(0).getCLevel()+1);
            }
        }
        int result = categoryService.addCategory(category2);
        if (result > 0) {
            String json = "{\"code\":\"success\"}";
            return json;
        }

        return "{\"msg\":\"新增失败\"}";
    }


}
