package com.guomei.controller;

import com.github.pagehelper.Page;
import com.guomei.pojo.PageInfo;
import com.guomei.pojo.UserInfo;
import com.guomei.pojo.Users;
import com.guomei.service.UserInfoService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/back/userInfo")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/findVip/{pageIndex}/{pageSize}")
    public PageInfo<Map> UserInfoFenYe(@RequestBody Map map, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize) {
        Page<Map> userInfoPage = userInfoService.UserInfoFenYe(map, pageIndex, pageSize);
        PageInfo<Map> page=new PageInfo<>();
        page.setList(userInfoPage.getResult());
        page.setTotalCount((int)userInfoPage.getTotal());
        return   page;
    }

}
