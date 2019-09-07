package com.guomei.dao;

import com.guomei.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersDao {
    //查询所有订单详情
    public List<Map<String,Object>> orderList(Map<String,Object>map);
    //根据订单号回显订单信息
    public List<Map<String,Object>> ByIdOrders(String orderNo);
    //修改订单状态
    public int updateStatus(Orders orders);
    //删除订单
    public int deleteOrder(int id);
    //订货单  订货金额
    public List<Map<String,Object>> orderQuantity();
    //退货单 退货金额
    public List<Map<String,Object>> returnQuantity ();
    //金额合计
    public double orderAmount();
}
