package com.leyou.item.mapper;

import com.leyou.item.pojo.TbItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-01-29 14:30
 */
public interface TbItemMapper extends Mapper<TbItem> {
    @Select("select * from tb_item where status = '2'")
    List<TbItem> findList();
    @Select("select sum(price) as amltomal,count(num) as total from tb_item where id='1'")
    Map<String, Object> findList2();
    @Select("select * from tb_item where cid=#{cid}")
    TbItem findById( Long cid);
    @Update("update tb_item set updatedLast=#{updatedLast} where id=#{id}")
    void updateTbItemById(TbItem tbItem);
}
