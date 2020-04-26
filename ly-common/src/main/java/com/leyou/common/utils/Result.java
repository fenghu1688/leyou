package com.leyou.common.utils;

import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * @author fenghu
 * @description: 統一返回对象
 * @date 2019-10-0116:07
 */
@Data
@ToString
public class Result<T> {
    static final String DEFAULT_ERR_CODE = "500";
    static final String DEFAULT_ERR_MSG = "unknown";
    static final String DEFAULT_SUCCESS_CODE = "200";
    static final String DEFAULT_SUCCESS_MSG = "ok";
    private T data;
    private String msg;
    private String code;

    private static <T> Result<T> build(T value, String code, String msg){
        Result<T> result = new Result<>();
        if (StringUtils.hasText(code)){
            result.setCode(code);
        }
        if (StringUtils.hasText(msg)){
            result.setMsg(msg);
        }
        if (value != null){
            result.setData(value);
        }
        return  result;
    }
    public static <T> Result<T> ok(){
        return build(null,DEFAULT_SUCCESS_CODE,DEFAULT_SUCCESS_MSG);
    }
    public static <T> Result<T> ok(T value){
        return build(value, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }
    public static <T> Result<T> ok(String code,String msg){
        return build(null, code, msg);
    }
    public static <T> Result<T> okMsg(String msg){
        return build(null, DEFAULT_SUCCESS_CODE, msg);
    }
    public static <T> Result<T> err(String msg){
        return build(null, DEFAULT_ERR_CODE, msg);
    }
    public static <T> Result<T> err(String code,String msg){
        if (StringUtils.isEmpty(code)){
            code = DEFAULT_ERR_CODE;
        }
        if (StringUtils.isEmpty(msg)){
            msg = DEFAULT_ERR_MSG;
        }
        return build(null, code, msg);
    }

}
