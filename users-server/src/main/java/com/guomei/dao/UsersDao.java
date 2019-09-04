package com.guomei.dao;

import com.guomei.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UsersDao {


    //管理员后台登录
    Users adminLogin(Users users);

    //查询用户
    List<Users> findUsers(@Param("userName") String userName);


}
