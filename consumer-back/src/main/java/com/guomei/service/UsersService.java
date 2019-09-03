package com.guomei.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("users-server")
public interface UsersService {
}
