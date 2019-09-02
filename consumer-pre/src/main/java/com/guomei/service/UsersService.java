package com.guomei.service;

import com.guomei.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("users-server")
public interface UsersService {

    @GetMapping("test")
    public String test();

    @RequestMapping("list")
    public List<Users> select();

}
