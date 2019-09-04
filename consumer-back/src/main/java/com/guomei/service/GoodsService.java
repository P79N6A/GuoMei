package com.guomei.service;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("product-server")
public interface GoodsService {

    @RequestMapping("Back/Goods/findCategory")
    String findCategory();

}
