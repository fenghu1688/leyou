package ly.test.controller.feignClient;

import com.leyou.common.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-05-13 9:48
 */
@FeignClient(value = "item-service",path = "/item")
public interface ItemFeignclient {

    @GetMapping(value = "/getItem/{id}",produces = "application/json")
    @ApiOperation(value="根据id查询商品",notes = "成功：200，失败：非200")
    Result<TbItem> getItemById(@PathVariable("id") Long id);
}
