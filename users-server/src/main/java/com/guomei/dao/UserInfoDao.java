package com.guomei.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoDao {

    //查询会员
    List<Map> findVip(Map map);

}
