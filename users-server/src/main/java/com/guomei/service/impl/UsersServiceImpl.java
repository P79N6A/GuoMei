package com.guomei.service.impl;


import com.guomei.dao.UsersDao;
import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;


    @Override
    public Users adminLogin(Users users) {
        return usersDao.adminLogin(users);
    }

    @Override
    public List<Users> findUsers(String userName) {
        return usersDao.findUsers(userName);
    }

    @Override
    public int delUser(Integer id) {
        return usersDao.delUser(id);
    }

    @Override
    public Users findById(Integer id) {
        return usersDao.findById(id);
    }

    @Override
    public int updateUser(Users user) {
        return usersDao.updateUser(user);
    }
}
