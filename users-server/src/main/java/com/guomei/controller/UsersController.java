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

    @RequestMapping("/findUsers/{userName}")
    public List<Users> findUsers(@PathVariable("userName") String userName) {
        return usersService.findUsers(userName);
    }

    @RequestMapping("/delUser/{id}")
    public int delUser(@PathVariable("id") Integer id) {
        return usersService.delUser(id);
    }

    @RequestMapping("/findById/{id}")
    public Users findById(@PathVariable("id") Integer id){
        return usersService.findById(id);
    }

    @RequestMapping("/updateUser")
    public int updateUser(@RequestBody Users user){
        return usersService.updateUser(user);
    }

}
