package com.leyou.item.api;

import com.leyou.common.utils.Result;
import com.leyou.item.pojo.TbItem;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-05-12 15:26
 */
@FeignClient(name = "item-service")
public interface ItemApi {

    @GetMapping(value = "/getItem/{id}",produces = "application/json")
    @ApiOperation(value="根据id查询商品",notes = "成功：200，失败：非200")
    Result<TbItem> getItemById(Long id);
}
