package com.guomei.service;

import com.guomei.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("users-server")
public interface UsersService_consumer {

    @RequestMapping("/adminLogin")
     Users adminLogin(Users users);

    @RequestMapping("/findUsers/{userName}")
     List<Users> findUsers(@PathVariable("userName") String userName);

    @RequestMapping("/delUser/{id}")
     int delUser(@PathVariable("id") Integer id);

    @RequestMapping("/findById/{id}")
     Users findById(@PathVariable("id") Integer id);

    @RequestMapping("/updateUser")
     int updateUser(Users user);

}
