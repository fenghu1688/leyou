package com.leyou.common.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/29:46
 */
@Data
public class PageResult<T>{
    private Long total;//总条数
    private Long totalPage;//总页数
    private List<T> items;//当页数据

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

}
