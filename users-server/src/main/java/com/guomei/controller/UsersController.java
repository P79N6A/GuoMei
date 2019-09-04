package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping("/adminLogin")
    public Users adminLogin(@RequestBody Users users){
        return  usersService.adminLogin(users);
    }

    @RequestMapping("/findUsers")
    public List<Users> findUsers(String userName) {
        return usersService.findUsers(userName);
    }


}
