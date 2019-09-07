package com.guomei.service;


import com.github.pagehelper.Page;
import com.guomei.pojo.Orders;
import com.guomei.pojo.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("order-server")
public interface OrdersService {
      //查询全部和模糊查询
    @RequestMapping("/Back/Orders/orderList/{pageIndex}/{pageSize}/{orderNo}/{name}")
    PageInfo<Map<String, Object>> orderList(@PathVariable("pageIndex")Integer pageIndex, @PathVariable("pageSize")Integer pageSize, @PathVariable("orderNo")String orderNo, @PathVariable("name")String name);
     //根据订单号查询
    @RequestMapping("/Back/Orders/ByIdOrders/{orderNo}")
    List<Map<String,Object>> ByIdOrders(@PathVariable("orderNo")String orderNo);
    //根据订单号修改
    @RequestMapping("/Back/Orders/updateStatus")
    int updateStatus(@RequestParam("orderNo") String orderNo,@RequestParam("status") int status);
    //删除
    @RequestMapping("/Back/Orders/deleteOrders")
    int deleteOrders(@RequestParam("orderId")Integer orderId);


}
