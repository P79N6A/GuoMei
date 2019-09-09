package com.guomei.controller;

import com.guomei.pojo.Category;
import com.guomei.pojo.Goods;
import com.guomei.pojo.PageInfo;
import com.guomei.service.GoodsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.applet.Main;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
        String json = goodsService.deleteCategory(cid);
        return json;
    }

    @RequestMapping("brandExistGood/{cid}")
    public String brandExistGood(@PathVariable("cid") Integer cid) {
        String json = goodsService.brandExistGood(cid);
        return json;
    }

    @RequestMapping("findTreeCategory/{cLevel}")
    public String findTreeCategory(@PathVariable("cLevel") Integer cLevel) {
        return goodsService.findTreeCategory(cLevel);
    }

    @RequestMapping("addCategory")
    public String addCategory(@RequestParam Map<String, String> map) {
        Category category = new Category();
        category.setName(map.get("parentName") + ":" + map.get("categoryName"));
        return goodsService.addCategory(category);
    }

    @RequestMapping("categoryShow")
    public List<Category> categoryShow(@RequestParam Map<String, String> param){
        return goodsService.categoryShow(param);
    }

    //商品模块
    @RequestMapping("findGoods")
    public Map<String, Object> findGoods(@RequestParam Map<String, Object> param) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Map<String, Object>> goods = goodsService.findGoods(param);
        map.put("code", 0);
        map.put("data", goods.getList());
        map.put("totalCount", goods.getTotalCount());
        return map;
    }

    @RequestMapping("UploadPhoto")
    public Map<String, Object> UploadPhoto(MultipartFile file, HttpServletRequest request) throws IOException {
        //图片存入路径
        String path = "D:/Nignx4FileServer/nginx-1.14.2/html/images";
        Map<String, Object> res = new HashMap<>();
        List<String> fileTyps = Arrays.asList("image/jpeg", "image/png", "image/gif");
        if (!file.isEmpty()) {    //传过来的文件不为空
            String uuid = UUID.randomUUID().toString();   //保证每个的文件名不重复
            //源文件名
            String originalFilename = uuid + file.getOriginalFilename();
            //文件的真实类型
            String contentType = file.getContentType();
            if (fileTyps.contains(contentType)) {
                File f = new File(path, originalFilename);
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdir();
                }
                //写入指定盘符
                file.transferTo(f);
            }

            //返回图片url
            res.put("url", "http://127.0.0.1:88/upload/" + originalFilename);
        }
        return res;
    }
    @RequestMapping("addGoods")
    public String addGoods(@RequestParam Map<String,Object> map){

        String s = goodsService.addGoods(map);
        return s;
    }

}
