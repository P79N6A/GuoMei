package com.guomei.service.impl;


import com.guomei.dao.OrdersDao;
import com.guomei.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Map<String, Object>> orderList(Map<String,Object> map) {

        return ordersDao.orderList(map);
    }

    @Override
    public List<Map<String, Object>> orderQuantity() {
        return ordersDao.orderQuantity();
    }

    @Override
    public List<Map<String, Object>> returnQuantity() {
        return ordersDao.returnQuantity();
    }

    @Override
    public double orderAmount() {
        return ordersDao.orderAmount();
    }
}
