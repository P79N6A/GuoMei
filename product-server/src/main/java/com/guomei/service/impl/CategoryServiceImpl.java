package com.guomei.service.impl;

import com.guomei.dao.CategoryDao;
import com.guomei.pojo.Category;
import com.guomei.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    @Override
    public List<Category> findCategory() {
        return categoryDao.findCategory();
    }

    @Override
    public Category findCategoryParent(Integer parentId) {
        return categoryDao.findCategoryParent(parentId);
    }
}
