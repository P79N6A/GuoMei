package com.guomei.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guomei.pojo.PageInfo;
import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/back/users")
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping("/adminLogin")
    public Users adminLogin(@RequestBody Users users){
        return  usersService.adminLogin(users);
    }

    @RequestMapping("/findUsers/{userName}/{pageIndex}/{pageSize}")
    public PageInfo<Users> UsersFenYe(@PathVariable("userName") String userName,@PathVariable("pageIndex") int pageIndex,@PathVariable("pageSize") int pageSize) {
        Page<Users> usersPage = usersService.UsersFenYe(userName, pageIndex, pageSize);
        PageInfo<Users> page=new PageInfo<>();
        page.setList(usersPage.getResult());
        page.setTotalCount((int)usersPage.getTotal());
        return   page;
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
