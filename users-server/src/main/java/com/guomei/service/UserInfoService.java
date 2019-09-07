package com.guomei.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface UserInfoService {

    List<Map> findVip(Map map);
}
