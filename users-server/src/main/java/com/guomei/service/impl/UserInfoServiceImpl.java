package com.guomei.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guomei.dao.UserInfoDao;
import com.guomei.pojo.UserInfo;
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
    public Page<Map> UserInfoFenYe(Map map, int pageIndex, int pageSize) {
        Page<Map> userInfoPage = PageHelper.startPage(pageIndex, pageSize);
        userInfoDao.findVip(map);
        return userInfoPage;
    }
}
