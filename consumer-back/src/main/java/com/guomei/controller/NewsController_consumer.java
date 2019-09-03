package com.guomei.controller;

import com.guomei.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/News")
@Controller
public class NewsController_consumer {

    @Autowired
    private NewsService newsService;
}
