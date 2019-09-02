package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "123321";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Users> findAll(){
        return usersService.findAll();
    }
}
