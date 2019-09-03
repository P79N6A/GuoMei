package com.guomei.controller;

import com.guomei.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;



}
