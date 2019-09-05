package com.guomei.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    /**
     * 查询所有订单详情
     * @return
     */
    public List<Map<String,Object>> orderList(Map<String,Object>map);
    //订货单  订货金额
    public List<Map<String,Object>> orderQuantity();
    //退货单 退货金额
    public List<Map<String,Object>> returnQuantity ();
    //金额合计
    public double orderAmount();
}
