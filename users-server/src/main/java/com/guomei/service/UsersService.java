package com.guomei.service;

import com.github.pagehelper.Page;
import com.guomei.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface UsersService {


    Users adminLogin(Users users);

    //分页
    Page<Users> UsersFenYe(String userName,int pageIndex, int pageSize);

    int  delUser(Integer id);

    Users   findById(Integer id);

    int updateUser(Users user);
}
