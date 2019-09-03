package com.guomei.dao;

import com.guomei.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersDao {


    //管理员后台登录
    Users adminLogin(Users users );
}
