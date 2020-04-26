package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1915:31
 */
@Service
public class CategoryServie {
    @Autowired
    private CategoryMapper categoryMapper;


    public List<TbContentCategory> getListCategoryByPid() {
        List<TbContentCategory> list = categoryMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.CATEGORY_NOTFIND);
        }
        return list;
    }
}
