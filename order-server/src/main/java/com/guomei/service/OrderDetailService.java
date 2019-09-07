package com.guomei.service;

public interface OrderDetailService {

    //删除订单详情(删除订单时先删除订单详情)
    public int deletOrderDetail(int orderId);
}
