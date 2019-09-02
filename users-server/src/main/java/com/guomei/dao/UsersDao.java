package com.guomei.dao;

import com.guomei.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersDao {
    List<Users> findAll();
}
