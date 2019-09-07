package com.guomei.service.impl;

import com.guomei.dao.UserInfoDao;
import com.guomei.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
private UserInfoDao userInfoDao;

    @Override
    public List<Map> findVip(Map map) {
        return userInfoDao.findVip(map);
    }
}
