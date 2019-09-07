package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.service.GoodsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/Goods")
@RestController
public class GoodsController_consumer {

    @Autowired
    private GoodsService goodsService;

    //商品分类模块
    @RequestMapping("findCategory")
    public String findCategory() {
        String json = "{\"data\":" + goodsService.findCategory() + "}";
        return json;
    }

    @RequestMapping("updateCategoryInfo/{cid}/{parentId}")
    public String updateCategoryInfo(@PathVariable("cid") Integer cid, @PathVariable("parentId") Integer parentId) {
        return goodsService.updateCategoryInfo(cid, parentId);
    }

    @RequestMapping("updateCategory")
    public String updateCategory(@RequestParam Map<String, String> request) {
        //用于封装数据
        Category category = new Category();
        category.setCid(Integer.valueOf(request.get("cid")));
        category.setName(request.get("categoryName"));
        category.setParentId(Integer.valueOf(request.get("categoryList")));
        String json = "{\"res\":" + goodsService.updateCategory(category) + "}";
        return json;

    }

    @RequestMapping("deleteCategory/{cid}")
    public String deleteCategory(@PathVariable("cid") Integer cid) {
        String json =  goodsService.deleteCategory(cid);
        return json;
    }

    @RequestMapping("brandExistGood/{cid}")
    public String brandExistGood(@PathVariable("cid") Integer cid){
        String json =  goodsService.brandExistGood(cid);
        return json;
    }
    @RequestMapping("findTreeCategory/{cLevel}")
    public String findTreeCategory(@PathVariable("cLevel")Integer cLevel){
        return goodsService.findTreeCategory(cLevel);
    }

    @RequestMapping("addCategory")
    public String addCategory(@RequestParam Map<String, String> map){
        Category category = new Category();
        category.setName(map.get("parentName")+":"+map.get("categoryName"));
        return goodsService.addCategory(category);
    }



    //商品模块
    @RequestMapping("findGoods")
    public String findGoods(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> list = goodsService.findGoods(new Goods());
        map.put("code",0);
        map.put("data", list);
        map.put("count",list.size());
        map.put("msg", "");
        String json = "{\"msg\":\"\",\"code\":0,\"data\":[{\"goods_des_img\":\"\",\"goods_price\":3452,\"goods_id\":1,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"哈哈哈\",\"goods_sub_title\":\"海尔冰箱就是牛\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"海尔冰箱\",\"goods_seckill\":0,\"goods_state\":1,\"goods_stock\":123},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":3,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"1\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"111\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":4,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":5,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":6,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":7,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":8,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":9,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":11,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":12,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":0,\"goods_id\":13,\"goods_main_img\":\"\",\"brand_name\":\"海信\",\"goods_des\":\"\",\"goods_sub_title\":\"\",\"brand_id\":1,\"shop_id\":1,\"goods_title\":\"1\",\"goods_seckill\":0,\"goods_state\":0,\"goods_stock\":0},{\"goods_des_img\":\"\",\"goods_price\":2099,\"goods_id\":2,\"goods_main_img\":\"\",\"brand_name\":\"美的\",\"goods_des\":\"\",\"goods_sub_title\":\"【国美预约安装电话4008113333】手机APP操控，强劲制冷热！光敏传感！\",\"brand_id\":6,\"shop_id\":2,\"goods_title\":\"美的（Midea）正1.5匹 智弧 智能 静音 光线感应 定速冷暖壁挂式空调挂机 KFR-35GW/WDAD3@\",\"goods_seckill\":0,\"goods_state\":-1,\"goods_stock\":999}],\"count\":12}";
        return json;
    }

}
