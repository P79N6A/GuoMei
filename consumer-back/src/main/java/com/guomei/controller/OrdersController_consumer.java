package com.guomei.controller;

import com.github.pagehelper.Page;
import com.guomei.pojo.Orders;
import com.guomei.pojo.PageInfo;
import com.guomei.service.OrdersService;
import jdk.nashorn.internal.parser.JSONParser;
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
        PageInfo<Map<String, Object>> mapPageInfo = ordersService.orderList(pageIndex, pageSize, orderNo, name);
        map.put("code",0);
        map.put("data",mapPageInfo.getList());
        map.put("totalCount",mapPageInfo.getTotalCount());
        System.out.println("pageIndex："+pageIndex);
        System.out.println("pageSize:"+pageSize);
        System.out.println("orderNo:"+orderNo+":name:"+name);
//        String list= JSON.toJSONString();
        ///String json="{\"code\":0,\"msg\":\"\",\"data\":"+mapPageInfo.getList()+",\"totalCount\":"+mapPageInfo.getTotalCount()+"}";
        //System.out.println(json);
        return map;
    }
}
