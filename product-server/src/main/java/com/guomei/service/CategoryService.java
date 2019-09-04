package com.guomei.service;

import com.guomei.pojo.Category;

import java.util.List;

public interface CategoryService {
    //查询所有分类
    List<Category> findCategory();

    //查询当前分类所在的父分类
    Category findCategoryParent(Integer parentId);
}
