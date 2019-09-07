package com.guomei.controller;

import com.github.pagehelper.Page;
import com.guomei.pojo.Orders;
import com.guomei.pojo.PageInfo;
import com.guomei.service.OrderDetailService;
import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Back/Orders")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailService orderDetailService;
    //查询所有订单详情
    @RequestMapping("/orderList/{pageIndex}/{pageSize}/{orderNo}/{name}")
    public PageInfo<Map<String, Object>> orderList(@PathVariable("pageIndex")Integer pageIndex, @PathVariable("pageSize")Integer pageSize, @PathVariable("orderNo")String orderNo, @PathVariable("name")String name){
        Map<String,Object>map=new HashMap<>();
        map.put("orderNo",orderNo);
        map.put("name",name);
        Page<Map<String, Object>> maps = ordersService.orderList(map, pageIndex, pageSize);
        PageInfo<Map<String, Object>>page=new PageInfo<>();
        List<Map<String, Object>> result = maps.getResult();
        //封装查询数据
        page.setList(result);
        //封装总记录数
        page.setTotalCount((int)maps.getTotal());
        return page;
    }

    //修改回显
    @RequestMapping("/ByIdOrders/{orderNo}")
   public List<Map<String,Object>> ByIdOrders(@PathVariable("orderNo")String orderNo){
        return ordersService.ByIdOrders(orderNo);
   }

   //修改订单状态
    @RequestMapping("/updateStatus")
    public int updateStatus(@RequestParam("orderNo") String orderNo,@RequestParam("status") int status){
            Orders orders=new Orders();
            orders.setStatus(status);
            orders.setOrderNo(orderNo);
            return  ordersService.updateStatus(orders);

    }

    //删除订单
    @RequestMapping("/deleteOrders")
    public int deleteOrders(@RequestParam("orderId")Integer orderId){
        System.out.println("提供者:"+orderId);
        //先删除订单详情表
        int i = orderDetailService.deletOrderDetail(orderId);
        int num=0;
        if(i>0) {
            num = ordersService.deleteOrder(orderId);
        }
        return num;
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
