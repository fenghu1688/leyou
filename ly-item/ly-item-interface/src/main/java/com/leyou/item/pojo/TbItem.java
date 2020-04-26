package com.leyou.item.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "tb_item")
@Api(value = "tb_item",tags = "商品类")
public class TbItem {
    /*
        商品id，同时也是商品编号
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        商品标题
    */
    private String title;

    /*
        商品卖点
    */
    private String sellPoint;

    /*
        商品价格，单位为：分
    */
    private Long price;

    /*
        库存数量
    */
    private Integer num;

    /*
        商品条形码
    */
    private String barcode;

    /*
        商品图片
    */
    private String image;

    /*
        所属类目，叶子类目
    */
    private Long cid;

    /*
        商品状态，1-正常，2-下架，3-删除
    */
    private Byte status;

    /*
        创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date created;

    /*
        更新时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updated;




}

