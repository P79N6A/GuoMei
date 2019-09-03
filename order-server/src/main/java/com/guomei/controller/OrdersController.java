package com.guomei.controller;

import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Back/Orders")
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
}
