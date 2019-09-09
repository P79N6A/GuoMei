package com.guomei.lx.service;

import com.guomei.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    //查询所有分类
    List<Category> findCategory(Map<String,Object> map);

    //查询当前分类所在的父分类
    Category findCategoryParent(Integer parentId);

    //修改分类
    int updateCategoryInfo(Category category);

    //查询生成zTree树状下拉框的分类值
    List<Map<String,Object>> findTreeCategory(Integer cLevel);

    //查询所有分类以及该分类是否存在父分类
    List<Map<String,Object>> findCategoryAndParentExist();

    //删除分类
    int deleteCategory(Integer cid);

    //查询当前品牌分类下是否有商品
    int brandExistGood (Integer cid);

    //删除品牌分类
    int deleteBrand(Integer cid);


    //新增分类
    int addCategory(Category category);


    //查询当前分类所在的品牌编号
    int selectBrandId(Integer cid);
}
