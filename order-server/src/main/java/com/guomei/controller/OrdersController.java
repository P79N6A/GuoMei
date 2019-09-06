package com.guomei.controller;

import com.github.pagehelper.Page;
import com.guomei.pojo.PageInfo;
import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Back/Orders")
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //查询所有订单详情
    @RequestMapping("/orderList/{pageIndex}/{pageSize}/{orderNo}/{name}")
    @ResponseBody
    public PageInfo<Object> orderList(@PathVariable("pageIndex")Integer pageIndex, @PathVariable("pageSize")Integer pageSize, @PathVariable("orderNo")String orderNo, @PathVariable("name")String name){
        Map<String,Object>map=new HashMap<>();
        map.put("orderNo",orderNo);
        map.put("name",name);
        Page<Map<String, Object>> maps = ordersService.orderList(map, pageIndex, pageSize);
        PageInfo<Object>page=new PageInfo<>();
        System.out.println("提供者maps:"+maps);
        return page;
    }


    //查询退货单,退货金额,金额合计,订货单 ,订货金额
    public Map<String,Object> inquiryAmount(){
        Map<String,Object> map=new HashMap<>();
        map.put("orderQuantity",ordersService.orderQuantity());
        map.put("returnQuantity",ordersService.returnQuantity());
        map.put("orderAmount",ordersService.orderAmount());
        return map;
    }
}
