package com.guomei.dao;

import com.guomei.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
    //查询所有分类
    List<Category> findCategory();

    //查询当前分类所在的父分类
    Category findCategoryParent(Integer parentId);
}
