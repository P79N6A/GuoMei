package com.guomei.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("order-server")
public interface OrdersService {

    @RequestMapping("/Back/Orders/orderList/{orderNo}/{name}")
    List<Map<String,Object>> orderList(@PathVariable("orderNo")String orderNo, @PathVariable("name")String name);
}
