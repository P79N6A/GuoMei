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
    //查询所有分类
    @RequestMapping("Back/Category/findCategory")
    String findCategory();

    //返回当前进行更新的分类信息
    @RequestMapping("Back/Category/updateCategoryInfo/{cid}/{parentId}")
    String updateCategoryInfo(@PathVariable("cid")Integer cid,@PathVariable("parentId") Integer parentId);

    //更新分类
    @RequestMapping("Back/Category/updateCategory")
    String updateCategory(Category category);

    //删除分类
    @RequestMapping("Back/Category/deleteCategory/{cid}")
    String deleteCategory(@PathVariable("cid") Integer cid);

    //查询当前品牌下是否有商品
    @RequestMapping("Back/Category/brandExistGood/{cid}")
    String brandExistGood(@PathVariable("cid")Integer cid);

    //返回树状图数据的分类
    @RequestMapping("Back/Category/findTreeCategory/{cLevel}")
    String findTreeCategory(@PathVariable("cLevel")Integer cLevel);

    //添加分类
    @RequestMapping("Back/Category/addCategory")
    String addCategory(Category category);

    //根据不同条件返回分类信息
    @RequestMapping("Back/Category/categoryShow")
    List<Category> categoryShow(@RequestParam Map<String, String> param);

    //商品模块
    //查询商品
    @RequestMapping("Back/Goods/findGoods")
    PageInfo<Map<String, Object>> findGoods(@RequestParam Map<String,Object> param);

    //新增商品
    @RequestMapping("Back/Goods/addGoods")
    String addGoods(@RequestParam Map<String,Object> map);
}
