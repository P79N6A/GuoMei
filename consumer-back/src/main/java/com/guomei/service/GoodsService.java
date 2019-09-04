package com.guomei.service;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@FeignClient("product-server")
public interface GoodsService {

    @RequestMapping("Back/Category/findCategory")
    String findCategory();

    @RequestMapping("Back/Category/updateCategoryInfo/{cid}")
    String updateCategoryInfo(@PathVariable("cid")Integer cid);

}
