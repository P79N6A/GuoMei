package com.guomei.service.impl;


import com.guomei.dao.GradeDao;
import com.guomei.pojo.Grade;
import com.guomei.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Grade> allGrade() {
        return gradeDao.allGrade();
    }
}
