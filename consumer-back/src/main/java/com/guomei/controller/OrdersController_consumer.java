package com.guomei.controller;

import com.github.pagehelper.Page;
import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Orders")
@Controller
public class OrdersController_consumer {

    @Autowired
    private OrdersService ordersService;

    //查询所有和模糊查询和分页
    @RequestMapping("/orderList/{pageIndex}/{pageSize}/{orderNo}/{name}")
    @ResponseBody
    public Map<String,Object> findOrders(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("pageSize")Integer pageSize,@PathVariable("orderNo")String orderNo, @PathVariable("name")String name){
        Map<String,Object>map=new HashMap<>();
//        List<Map<String,Object>> list =ordersService.orderList(orderNo,name);
//        System.out.println("orderNo:"+orderNo+";name:"+name);
        Page<Map<String, Object>> maps = ordersService.orderList(pageIndex,pageSize, orderNo, name);
        map.put("code",0);
        map.put("data",maps.getResult());
        map.put("totalCount",maps.getTotal());
        System.out.println("map:"+maps);
        return map;
    }
}
