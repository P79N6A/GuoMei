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

    //删除用户
   int  delUser(Integer id);

   //根据id查询用户信息
    Users   findById(Integer id);

    //修改用户
   int updateUser(Users user);


}
