package com.leyou.item.mapper;

import com.leyou.item.pojo.CategoryBrand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

/**
 * @author fenghu
 * @description: TODO
 * @date 2021-01-14 19:19
 */
public interface ContentCategoryMapper extends Mapper<CategoryBrand> {

    @Insert("<script>"+
            "insert into tb_category_brand (category_id,brand_id) values "+
            "<foreach collection='list' item='item' separator=','>"+
            "(#{item.categoryId},#{item.brandId})"+
            "</foreach>"+
            "</script>")
    void insertList(@Param("list") ArrayList<CategoryBrand> list);
}
