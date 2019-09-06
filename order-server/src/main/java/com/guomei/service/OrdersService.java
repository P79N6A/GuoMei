package com.guomei.service;

import com.github.pagehelper.Page;
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
    //订货单  订货金额
    public List<Map<String,Object>> orderQuantity();
    //退货单 退货金额
    public List<Map<String,Object>> returnQuantity ();
    //金额合计
    public double orderAmount();
}
