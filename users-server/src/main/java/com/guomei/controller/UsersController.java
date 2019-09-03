package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping("/adminLogin")
    @ResponseBody
    public Users adminLogin(@RequestBody Users users){
        return  usersService.adminLogin(users);
    }
}
