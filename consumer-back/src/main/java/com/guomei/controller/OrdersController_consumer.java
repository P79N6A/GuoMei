package com.guomei.controller;

import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Orders")
@Controller
public class OrdersController_consumer {

    @Autowired
    private OrdersService ordersService;


    //查询所有订单
    @RequestMapping("/orderList/{orderNo}/{name}")
    @ResponseBody
    public Map<String,Object> findOrders(@PathVariable("orderNo")String orderNo, @PathVariable("name")String name){
        List<Map<String, Object>> list =null;
        if(orderNo==null&&name==null){
            list=ordersService.orderList("","");
        }else{
            list=ordersService.orderList(orderNo,name);
        }
        System.out.println("orderNo:"+orderNo+";name:"+name);

        //创建传往后台的map
        Map<String,Object> maps=new HashMap<String,Object>();
        maps.put("code",0);
        maps.put("data",list);
        maps.put("msg","");
        maps.put("count",100);

        return maps;
    }
}
