package com.guomei.controller;

import com.guomei.pojo.Users;
import com.guomei.service.UsersService_consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@Controller
public class UsersController_consumer {

    @Autowired
    private UsersService_consumer usersService_consumer;

    //管理员后台登录
    @RequestMapping("/back/adminLogin")
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

    //查询用户
    @RequestMapping("/back/findUsers")
    @ResponseBody
    public Map<String,Object> findUsers(String userName){
        List<Users>    list = usersService_consumer.findUsers(userName);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",list.size());
        map.put("data",list);
        return map ;
    }


}
