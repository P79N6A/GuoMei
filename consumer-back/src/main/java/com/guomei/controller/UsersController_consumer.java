package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService_consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/Users")
@Controller
public class UsersController_consumer {

    @Autowired
    private UsersService_consumer usersService_consumer;

    //管理员后台登录
    @RequestMapping("/Back/adminLogin")
    public String adminLogin(Users users, Model model) {
        //解密
        //String password = DigestUtils.md5DigestAsHex(users.getPassWord().getBytes());
       // users.setPassWord(password);
        if (usersService_consumer.adminLogin(users) == null) {
            model.addAttribute("errorMess", "用户名或密码错误");
            return "login";
        } else {
            return "frame";
        }
    }



}
