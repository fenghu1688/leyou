package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.pojo.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1915:31
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    public List<CategoryBrand> getListCategoryByPid() {

        return null;
    }

    public List<String> queryNameByIds(List<Long> ids) {
        return this.categoryMapper.selectByIdList(ids).stream().map(Category::getName).collect(Collectors.toList());
    }
}
