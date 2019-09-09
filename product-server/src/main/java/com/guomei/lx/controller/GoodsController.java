package com.guomei.lx.controller;


import com.github.pagehelper.Page;
import com.guomei.lx.service.CategoryService;
import com.guomei.pojo.Goods;
import com.guomei.lx.service.GoodsService;
import com.guomei.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Back/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("findGoods")
    public PageInfo<Map<String, Object>> findGoods(@RequestParam Map<String, Object> param) {
        Map<String, Object> map = new HashMap<>();
        map.put("cname", param.get("cname"));
        map.put("title", param.get("title"));
        Integer pageIndex = new Integer(param.get("pageIndex").toString());
        Integer pageSize = new Integer(param.get("pageSize").toString());
        Page<Map<String, Object>> goods = goodsService.findGoods(map, pageIndex, pageSize);

        PageInfo<Map<String, Object>>page=new PageInfo<>();
        List<Map<String, Object>> result = goods.getResult();
        //封装查询数据
        page.setList(result);
        //封装总记录数
        page.setTotalCount((int)goods.getTotal());
        return page;
    }



    @RequestMapping("addGoods")
    public String addGoods(@RequestParam Map<String,Object> map){
        System.out.println("map = " + map);
        Integer vip = new Integer(map.get("vip").toString());
        Integer ms = new Integer(map.get("ms").toString());
        Integer cid = new Integer(map.get("brand").toString());
        int brandid = categoryService.selectBrandId(cid);
        int res = 0;
        if(ms==1){ //新增到秒杀商品中

        }
        if(vip==1){ //新增到会员商品中

        }
        map.put("brand",brandid);
        res = goodsService.addGoods(map);
        if (res > 0) {
            String json = "{\"code\":\"success\"}";
            return json;
        }
        return "{\"msg\":\"新增失败\"}";
    }

}