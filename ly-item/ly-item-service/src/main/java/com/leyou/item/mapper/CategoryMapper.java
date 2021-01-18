package com.leyou.item.mapper;

import com.leyou.item.dto.CategoryDto;
import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1914:55
 */
public interface CategoryMapper extends Mapper<Category> , SelectByIdListMapper<Category, Long> {

    @Select("select id,name,parent_id,is_parent,sort from tb_category where is_parent='1' and sort='1'  order by sort ASC ")
    @Results( value = {
            @Result(id = true,column = "id",property = "id",jdbcType = JdbcType.BIGINT),
            @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_id",property = "parentId",jdbcType = JdbcType.BIGINT),
            @Result(column = "is_parent",property = "isParent",jdbcType = JdbcType.TINYINT),
            @Result(column = "sort",property = "sort",jdbcType = JdbcType.TINYINT),
            @Result(column = "id",property = "categoryDtos",many = @Many(select = "com.leyou.item.mapper.CategoryMapper.ListByParentId"))})
    List<CategoryDto> listAll();

    @ResultMap("resultMap")
    @Select("select id,name,parent_id,is_parent,sort from tb_category  where parent_id='0'  order by id ASC ")
    List<Category> listAll2();


    @Select("select * from tb_category where parent_id=#{id} order by sort ASC ")
    @ResultMap("resultMap")
    List<CategoryDto> ListByParentId(@Param("id") String id);


    @Select("select * from tb_category")
    @Results({@Result(id = true,column = "id",property = "id"),
    @Result(column = "cid",property = "items",many = @Many(select="com.leyou.item.mapper.TbItemMapper.findById",fetchType = FetchType.EAGER))})
    Category selectByID(Long id);


    @Select("select * from tb_category where parent_id=#{parent_id}")
    @Results(id = "resultMap", value = {
             @Result(id = true,column = "id",property = "id",jdbcType = JdbcType.BIGINT),
             @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR),
             @Result(column = "parent_id",property = "parentId",jdbcType = JdbcType.BIGINT),
             @Result(column = "is_parent",property = "isParent",jdbcType = JdbcType.TINYINT),
             @Result(column = "sort",property = "sort",jdbcType = JdbcType.TINYINT)})
    List<Category> queryListByParent(@Param("parent_id") Long pid);

    @Select("select * from tb_category where parent_id <>'0' order by parent_id ASC ")
    @ResultMap("resultMap")
    List<Category> selectAllOrderByParentId();
}
