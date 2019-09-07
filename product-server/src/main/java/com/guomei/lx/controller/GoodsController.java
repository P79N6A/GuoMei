package com.guomei.lx.controller;


import com.github.pagehelper.Page;
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

    @RequestMapping("findGoods")
    private PageInfo<Map<String, Object>> findGoods(@RequestParam Map<String, Object> param) {
        Map<String, Object> map = new HashMap<>();
        map.put("cname", param.get("cname"));
        map.put("title", param.get("title"));
        System.out.println("param = " + param);
        Integer pageIndex = new Integer(param.get("pageIndex").toString());
        System.out.println("pageIndex = " + pageIndex);
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


}