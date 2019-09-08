package com.guomei.dao;

import com.guomei.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeDao {

    //所有的会员等级
    List<Grade> allGrade();
}
