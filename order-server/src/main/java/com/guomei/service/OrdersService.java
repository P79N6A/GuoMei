package com.guomei.service;

import com.github.pagehelper.Page;
import com.guomei.pojo.Orders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    /**
     * 查询所有订单详情
     * @return
     */
    public Page<Map<String,Object>> orderList(Map<String,Object>map,int pageIndex,int pageSize);
    //根据订单号回显订单信息
    public List<Map<String,Object>> ByIdOrders(String orderNo);
    //修改订单状态
    public int updateStatus(Orders orders);
    //删除订单
    public int deleteOrder(int orderId);
    //订货单  订货金额
    public List<Map<String,Object>> orderQuantity();
    //退货单 退货金额
    public List<Map<String,Object>> returnQuantity ();
    //金额合计
    public double orderAmount();
}
