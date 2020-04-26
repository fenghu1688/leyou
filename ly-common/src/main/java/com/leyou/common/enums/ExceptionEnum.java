package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1815:49
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    AGE_CANNOT_BE_NULL(401,"xingming不可以为null"),
    CATEGORY_NOTFIND(404,"数据库查询为空"),
    ITEMDESC_NOT_FOUND(404,"未找到商品描述"),
    UPLOADIMAGE_ERROR(500,"图片上传失败")
    ;
    private int code;
    private  String msg;
}
