package com.guomei.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guomei.dao.UsersDao;
import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public Page<Users> UsersFenYe(String userName, int pageIndex, int pageSize) {
        Page<Users> usersPage = PageHelper.startPage(pageIndex, pageSize);
        usersDao.findUsers(userName);
        return usersPage;
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
