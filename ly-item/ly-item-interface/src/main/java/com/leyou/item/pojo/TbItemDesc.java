package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "tb_item_desc")
public class TbItemDesc {
    /*
        商品ID
    */
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(useGeneratedKeys = true)
    @Column(name="item_id")
    private Long itemId;

    /*
        商品描述
    */
    @Column(name = "item_desc")
    private String itemDesc;

    /*
        创建时间
    */
    private Date created;

    /*
        更新时间
    */
    private Date updated;



}

