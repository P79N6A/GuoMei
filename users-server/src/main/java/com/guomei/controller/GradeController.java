package com.guomei.controller;

import com.guomei.pojo.Grade;
import com.guomei.service.GradeService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/back/grade")
@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/allGrade")
    public List<Grade> allGrade() {
        return gradeService.allGrade();
    }
}
