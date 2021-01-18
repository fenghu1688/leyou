package com.leyou.item.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
public class
CategoryDto {
    /*
        类目id
    */

    private Long id;

    /*
        类目名称
    */
    private String name;

    /*
        父类目id,顶级类目填0
    */
    private Integer parentId;

    /*
        是否为父节点，0为否，1为是
    */
    private Integer isParent;

    /*
        排序指数，越小越靠前
    */
    private Integer sort;

    private List<CategoryDto> categoryDtos;


}

