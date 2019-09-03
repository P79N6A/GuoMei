package com.guomei.controller;

import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/Orders")
@Controller
public class OrdersController_consumer {

    @Autowired
    private OrdersService ordersService;

    @ResponseBody
    @RequestMapping("test")
    public String test(){
        String json = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"categoryId\": 1,\n" +
                "      \"categoryName\": \"分类\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": -1\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 2,\n" +
                "      \"categoryName\": \"用户管理\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 3,\n" +
                "      \"categoryName\": \"查询用户\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 4,\n" +
                "      \"categoryName\": \"添加用户\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 5,\n" +
                "      \"categoryName\": \"修改用户\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 6,\n" +
                "      \"categoryName\": \"删除用户\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 7,\n" +
                "      \"categoryName\": \"角色管理\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 8,\n" +
                "      \"categoryName\": \"查询角色\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 9,\n" +
                "      \"categoryName\": \"添加角色\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 10,\n" +
                "      \"categoryName\": \"修改角色\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 11,\n" +
                "      \"categoryName\": \"删除角色\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"categoryId\": 12,\n" +
                "      \"categoryName\": \"角色权限管理\",\n" +
                "      \"menuUrl\": 123,\n" +
                "      \"parentId\": 7\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return json;
    }
}
