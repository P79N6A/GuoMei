package com.guomei.service.impl;

import com.guomei.dao.OrderDetailDao;
import com.guomei.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceimpl implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Override
    public int deletOrderDetail(int orderId) {
        return orderDetailDao.deletOrderDetail(orderId);
    }
}
