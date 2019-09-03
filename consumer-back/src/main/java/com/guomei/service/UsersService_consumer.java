package com.guomei.service;

import com.guomei.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("users-server")
public interface UsersService {

    @RequestMapping("/adminLogin")
     Users adminLogin(Users users);

    
}
