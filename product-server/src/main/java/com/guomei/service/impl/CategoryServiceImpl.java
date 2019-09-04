package com.guomei.service.impl;

import com.guomei.dao.CategoryDao;
import com.guomei.pojo.Category;
import com.guomei.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findCategory(Map<String,Object> map) {
        return categoryDao.findCategory(map);
    }

    @Override
    public Category findCategoryParent(Integer parentId) {
        return categoryDao.findCategoryParent(parentId);
    }
}
