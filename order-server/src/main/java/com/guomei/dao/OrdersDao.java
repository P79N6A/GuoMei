package com.guomei.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersDao {
    //查询所有订单详情
    public List<Map<String,Object>> orderList(Map<String,Object>map);
    //订货单  订货金额
    public List<Map<String,Object>> orderQuantity();
    //退货单 退货金额
    public List<Map<String,Object>> returnQuantity ();
    //金额合计
    public double orderAmount();
}
