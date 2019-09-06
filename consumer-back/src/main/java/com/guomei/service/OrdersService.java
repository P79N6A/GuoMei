package com.guomei.service;


import com.github.pagehelper.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("order-server")
public interface OrdersService {
      //查询全部和模糊查询
    @RequestMapping("/Back/Orders/orderList/{pageIndex}/{pageSize}/{orderNo}/{name}")
    Page<Map<String,Object>> orderList(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("pageSize")Integer pageSize, @PathVariable("orderNo")String orderNo, @PathVariable("name")String name);

}
