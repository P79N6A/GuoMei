package com.guomei.service;

import com.github.pagehelper.Page;
import com.guomei.pojo.UserInfo;
import com.guomei.pojo.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface UserInfoService {

    //分页
    Page<Map> UserInfoFenYe(Map map, int pageIndex, int pageSize);
}
