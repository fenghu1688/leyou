package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "tb_category_brand")
public class CategoryBrand {

    /*
        商品类目id
    */
    private Long categoryId;

    /*
        品牌id
    */
    private Long brandId;




}

