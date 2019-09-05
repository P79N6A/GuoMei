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

    @Override
    public int updateCategoryInfo(Category category) {
        return categoryDao.updateCategoryInfo(category);
    }

    @Override
    public List<Map<String, Object>> findCategoryAndParentExist() {
        return categoryDao.findCategoryAndParentExist();
    }

    @Override
    public int deleteCategory(Integer cid) {
        return categoryDao.deleteCategory(cid);
    }

    @Override
    public int brandExistGood(Integer cid) {
        return categoryDao.brandExistGood(cid);
    }

    @Override
    public int deleteBrand(Integer cid) {
        return categoryDao.deleteBrand(cid);
    }

}
