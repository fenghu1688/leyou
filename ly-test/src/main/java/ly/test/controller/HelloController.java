package ly.test.controller;

import com.leyou.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ly.test.controller.feignClient.ItemFeignclient;
import ly.test.controller.feignClient.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-05-13 9:48
 */
@RestController
@Api("测试类")
public class HelloController {
    @Autowired
    private ItemFeignclient itemFeignclient;

    @GetMapping(value = "hello/{id}",produces = "application/json")
    @ApiOperation(value = "远程调用方法")
    public Result<TbItem> test(@PathVariable("id") Long id ){
        return itemFeignclient.getItemById(id);
    }

    public static void main(String[] args) {
        TbItem tbItem = new TbItem();
        System.out.println(tbItem);
        if (tbItem == null){
            System.out.println(1);
        }
        TbItem tbItem1 = null;
        if (null == tbItem1){

            System.out.println(2);
        }

    }
}
