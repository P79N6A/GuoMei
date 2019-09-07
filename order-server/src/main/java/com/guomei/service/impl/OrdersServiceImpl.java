package com.guomei.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guomei.dao.OrdersDao;
import com.guomei.pojo.Orders;
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
    public Page<Map<String, Object>> orderList(Map<String,Object> map,int pageIndex, int pageSize) {
        Page<Map<String, Object>> page = PageHelper.startPage(pageIndex, pageSize);
        ordersDao.orderList(map);
        return page;
    }

    @Override
    public List<Map<String, Object>> ByIdOrders(String orderNo) {
        return ordersDao.ByIdOrders(orderNo);
    }

    @Override
    public int updateStatus(Orders orders) {
        return ordersDao.updateStatus(orders);
    }

    @Override
    public int deleteOrder(int orderId) {
        return ordersDao.deleteOrder(orderId);
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
