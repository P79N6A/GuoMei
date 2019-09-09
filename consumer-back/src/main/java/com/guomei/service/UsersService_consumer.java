package com.guomei.service;

import com.github.pagehelper.Page;
import com.guomei.pojo.Grade;
import com.guomei.pojo.PageInfo;
import com.guomei.pojo.UserInfo;
import com.guomei.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@FeignClient("users-server")
public interface UsersService_consumer {

    @RequestMapping("/back/users/adminLogin")
     Users adminLogin(Users users);

    @RequestMapping("/back/users/findUsers/{userName}/{pageIndex}/{pageSize}")
    PageInfo<Users> UsersFenYe(@PathVariable("userName") String userName,@PathVariable("pageIndex") int pageIndex,@PathVariable("pageSize") int pageSize);

    @RequestMapping("/back/users/findUsers/{userName}")
     List<Users> findUsers(@PathVariable("userName") String userName) ;

    @RequestMapping("/back/users/delUser/{id}")
     int delUser(@PathVariable("id") Integer id);

    @RequestMapping("/back/users/findById/{id}")
     Users findById(@PathVariable("id") Integer id);

    @RequestMapping("/back/users/updateUser")
     int updateUser(Users user);

    @RequestMapping("/back/userInfo/findVip/{pageIndex}/{pageSize}")
     PageInfo<Map> UserInfoFenYe(@RequestBody Map map, @PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize);

    @RequestMapping("/back/grade/allGrade")
     List<Grade> allGrade() ;

}
