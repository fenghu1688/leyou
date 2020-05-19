package com.leyou.upload.feignClient;

import com.leyou.common.utils.Result;
import com.leyou.upload.domain.TbItem;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-05-12 15:38
 */
@FeignClient(value = "item-service")
public interface ItemFeignClient {

    @GetMapping("/getItem/{id}")
    @ApiOperation(value="根据id查询商品",notes = "成功：200，失败：非200")
    Result<TbItem> getItemById(Long id);
}
