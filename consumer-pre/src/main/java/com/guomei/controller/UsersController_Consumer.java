package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/Users")
@Controller
public class UsersController_Consumer {


    @Autowired
    private UsersService usersService;


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return usersService.test();
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Users> select(){
        return usersService.select();
    }
}
