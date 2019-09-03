package com.guomei.service.impl;


import com.guomei.dao.UsersDao;
import com.guomei.pojo.Users;
import com.guomei.service.UsersService;
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
}
