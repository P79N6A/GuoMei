package com.guomei.service;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.pojo.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@FeignClient("product-server")
public interface GoodsService {

    //商品分类模块
    @RequestMapping("Back/Category/findCategory")
    String findCategory();

    @RequestMapping("Back/Category/updateCategoryInfo/{cid}/{parentId}")
    String updateCategoryInfo(@PathVariable("cid")Integer cid,@PathVariable("parentId") Integer parentId);

    @RequestMapping("Back/Category/updateCategory")
    String updateCategory(Category category);

    @RequestMapping("Back/Category/deleteCategory/{cid}")
    String deleteCategory(@PathVariable("cid") Integer cid);

    @RequestMapping("Back/Category/brandExistGood/{cid}")
    String brandExistGood(@PathVariable("cid")Integer cid);

    @RequestMapping("Back/Category/findTreeCategory/{cLevel}")
    String findTreeCategory(@PathVariable("cLevel")Integer cLevel);

    @RequestMapping("Back/Category/addCategory")
    String addCategory(Category category);

    @RequestMapping("Back/Category/categoryShow")
    List<Category> categoryShow(@RequestParam Map<String, String> param);

    //商品模块
    @RequestMapping("Back/Goods/findGoods")
    PageInfo<Map<String, Object>> findGoods(@RequestParam Map<String,Object> param);
}
