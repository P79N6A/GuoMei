package com.guomei.controller;

import com.guomei.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Users")
@Controller
public class UsersController_consumer {

    @Autowired
    private UsersService usersService;
}
