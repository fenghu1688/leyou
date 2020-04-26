package com.leyou.item.mapper;

import com.leyou.item.pojo.TbCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-02-09 1:41
 */
public interface TbCategoryMapper extends Mapper<TbCategory> {
    @Select("select * from tb_category where parent_id = #{parentId} ")
    List<TbCategory> selectAllByParentId(@Param("parentId") String parentId);
}
