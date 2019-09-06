package com.guomei.service;

import com.guomei.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface UsersService {


    Users adminLogin(Users users);

    List<Users> findUsers(String userName);

    int  delUser(Integer id);

    Users   findById(Integer id);

    int updateUser(Users user);
}
