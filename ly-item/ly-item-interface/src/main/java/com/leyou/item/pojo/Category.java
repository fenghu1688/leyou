package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1914:48
 */
@Table(name = "tb_content_category")
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long parent_id;
    private String name;
    private Long status;
    private Long sort_order;
    private Long is_parent;
    private Date created;
    private Date updated;

}
