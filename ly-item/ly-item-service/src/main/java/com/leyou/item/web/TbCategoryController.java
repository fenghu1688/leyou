package com.leyou.item.web;

import com.leyou.common.utils.Result;
import com.leyou.item.mapper.TbCategoryMapper;
import com.leyou.item.pojo.TbCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-02-09 1:38
 */
@RestController
@RequestMapping("tbCategory")
@Api(value = "tbCategory",tags = "商品类目")
public class TbCategoryController {
    @Autowired
    private TbCategoryMapper tbCategoryMapper;
    @ApiOperation(value = "商品查询列表",notes = "成功：200，失败：非200")
    @GetMapping("listCategory/{parentId}")
    public Result<List<TbCategory>> listCategoryByParentId(@PathVariable @ApiParam("商品类目ID") Long parentId){
//        List<TbCategory> categoryList = tbCategoryMapper.selectAll();
//        List<TbCategory> categoryList = tbCategoryMapper.selectAllByParentId(parentId);
        TbCategory tbCategory = new TbCategory();
        tbCategory.setParentId(parentId);

        List<TbCategory> categoryList = tbCategoryMapper.select(tbCategory);
        return Result.ok(categoryList);
    }
}
