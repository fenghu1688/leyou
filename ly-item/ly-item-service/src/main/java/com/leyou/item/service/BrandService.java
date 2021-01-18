package com.leyou.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.pojo.PageResult;
import com.leyou.common.utils.Result;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.ContentCategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.CategoryBrand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    public PageResult<Brand> queryBrandByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%")
                    .orEqualTo("letter", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(),(long)pageInfo.getPages(), pageInfo);
    }

    @Transactional
    public Result saveBrand(Brand brand, List<Long> cids) {
        brandMapper.insert(brand);
        ArrayList<CategoryBrand> list = new ArrayList<>();
        cids.forEach(cid->{
            CategoryBrand categoryBrand = new CategoryBrand();
            categoryBrand.setBrandId(brand.getId());
            categoryBrand.setCategoryId(cid);
            list.add(categoryBrand);
            });
        contentCategoryMapper.insertList(list);
        return Result.ok();
    }
}