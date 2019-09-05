package com.guomei.controller;

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
    @RequestMapping("/orderList/{orderNo}/{name}")
    @ResponseBody
    public List<Map<String,Object>> orderList(@PathVariable("orderNo")String orderNo, @PathVariable("name")String name){
        Map<String,Object>map=new HashMap<>();
        map.put("orderNo",orderNo);
        map.put("name",name);
        return ordersService.orderList(map);
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
