package com.guomei.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailDao {
     //删除订单详情(删除订单时先删除订单详情)
    public int deletOrderDetail(int orderId);
}
