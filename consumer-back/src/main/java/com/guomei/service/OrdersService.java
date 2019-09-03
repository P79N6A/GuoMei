package com.guomei.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("order-server")
public class OrdersService {
}
