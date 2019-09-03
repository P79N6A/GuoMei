package com.guomei.service.impl;


import com.guomei.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersServiceImpl {
    @Autowired
    private OrdersDao ordersDao;
}
