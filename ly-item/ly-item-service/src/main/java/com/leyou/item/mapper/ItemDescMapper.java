package com.leyou.item.mapper;

import com.leyou.item.pojo.TbItemDesc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/29:54
 */
public interface ItemDescMapper extends Mapper<TbItemDesc> {
    @Insert("insert into tb_item_desc (item_id,item_desc,created,updated) values(#{item_id},#{item_desc},#{created},#{updated})")
    void insertItemDesc(@Param("item_id") Long item_id, @Param("item_desc") String item_desc, @Param("created") Date created, @Param("updated") Date updated);
}
