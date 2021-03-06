package com.leyou.upload.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data

public class TbItem {
    /*
        商品id，同时也是商品编号
    */

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

