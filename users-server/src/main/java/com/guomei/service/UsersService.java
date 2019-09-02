package com.guomei.service;

import com.guomei.pojo.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface UsersService {
    List<Users> findAll();
}
