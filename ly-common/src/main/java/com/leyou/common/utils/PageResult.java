package com.leyou.common.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author fenghu
 * @description: 分页统一返回对象
 * @date 2019-10-0116:35
 */
@Data
@ToString
@EqualsAndHashCode
public class PageResult<V> extends Result<List<V>> {
    static final String VALUE_IS_NULL_ERR_MSG = "value is null";
    private int page = 0;
    private int size = 0;
    private long total = 0L;
    private String sort = null;

    private static <V> PageResult<V> build(List<V> value,  int page, int size, long total, String sort,String code, String msg){
        PageResult pageResult = new PageResult();
        if (StringUtils.hasText(code)){
            pageResult.setCode(code);
        }
        if (StringUtils.hasText(msg)){
            pageResult.setMsg(msg);
        }
        pageResult.setPage(page);
        pageResult.setSize(size);
        pageResult.setTotal(total);
        pageResult.setSort(sort);
        pageResult.setData(value);

        return pageResult;
    }
    public static <V> PageResult ok(Page<V> page,String code ,String msg){
        if (page == null){
            throw new RuntimeException(VALUE_IS_NULL_ERR_MSG);
        }
        return build(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements(),
                page.getSort().toString(), code, msg);
    }
    public static <V> PageResult<V> ok(Page<V> page){
        return ok(page, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }

    public static <V> PageResult<V> ok(Page<V> page,String msg){
        return ok(page, DEFAULT_SUCCESS_CODE, msg);
    }

    public static PageResult ok(){
        return build(null, 0, 0, 0L, null, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }

    public static <V> PageResult<V> ok(List<V> value){
        if (value == null){
            throw new RuntimeException(VALUE_IS_NULL_ERR_MSG);
        }
        return build(value, 0, value.size(), 0L, null, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MSG);
    }
    public static PageResult ok(String code, String msg){
        return build(null, 1, 10, 0L, null, code, msg);
    }
    public static PageResult ok(String msg){
        return build(null, 1, 10, 0L, null, DEFAULT_SUCCESS_CODE, msg);
    }
    public static PageResult err(String msg){
        return build(null, 1, 10, 0L, null, DEFAULT_ERR_CODE, msg);
    }
    public static PageResult err(String code, String msg){
        if (StringUtils.isEmpty(code)){
            code=DEFAULT_ERR_CODE;
        }
        if (StringUtils.isEmpty(msg)) {
            msg = DEFAULT_ERR_MSG;
        }
        return build(null, 1, 10, 0L, null, code, msg);
    }
    public static <T,V> PageResult<V> convert(Page<T> page, Function<T,V> transfer){
        List<V> value=null;
        if (transfer !=null){
            value = page.map(transfer).getContent();
        }
        return build(value, page.getNumber(), page.getSize(), page.getTotalElements(), page.getSort()
                .toString(), DEFAULT_ERR_CODE, DEFAULT_ERR_MSG);
    }

    private static Sort newSort(String sortString){
        if (StringUtils.isEmpty(sortString)){
            return null;
        }else {
            String[] sortFields=sortString.split(",");

            if (sortFields.length > 0){
                ArrayList<Sort.Order> orders = new ArrayList<>();
                for (String sortField : sortFields) {
                    String[] sortFieldSplit = sortField.split(":");
                    if (sortFieldSplit.length > 0){
                        // 排序方式：升序或降序
                        Sort.Direction direction=Sort.DEFAULT_DIRECTION;
                        String property = sortFieldSplit[0].trim();
                        if (StringUtils.hasText(property)){
                            // 忽略排序字段为空的
                            if (sortFieldSplit.length > 1){
                                Optional<Sort.Direction> t = Sort.Direction.fromOptionalString(sortFieldSplit[1].trim());
                                direction = t.orElse(null);
                            }
                            orders.add(new Sort.Order(direction, property));
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 构建 Pageable 对象
     * @param pageRequest
     * @return
     */
    public static Pageable buildPageable(PageRequest pageRequest){
        Sort sort=null;
        if (!StringUtils.isEmpty(pageRequest.getSort().toString())){
            sort = newSort(pageRequest.getSort().toString());
        }
        return PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), sort);

    }
    public int getTotalPage(){
        int size = 10;
        if (this.size > 0){
            size = this.size;
        }
        return (int) ((total + size - 1) / size);
    }

}
