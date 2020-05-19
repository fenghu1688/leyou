package com.leyou.item.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.utils.Result;
import com.leyou.item.api.ItemApi;
import com.leyou.item.mapper.TbItemMapper;
import com.leyou.item.pojo.Item;
import com.leyou.item.pojo.TbItem;
import com.leyou.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1813:57
 */
@RestController
@RequestMapping("item")
@Api(value = "item",tags = "商品")
@Slf4j
public class ItemControler  implements ItemApi {

    @Autowired
    private ItemService itemService;
    @Autowired
    private TbItemMapper itemMapper;
 /*   @PostMapping("/saveItem")
    @ApiOperation(value="保存商品",notes = "成功：200，失败：非200")
    public ResponseEntity<Item> saveItem(@RequestParam @RequestBody @ApiParam("商品") Item item){
        if(item.getName()==null){
            throw new LyException(ExceptionEnum.AGE_CANNOT_BE_NULL);
        }
        if (item.getPrice() == null) {

            throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }

        item = itemService.saveItem(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }*/

    @GetMapping(value = "/getItem/{id}",produces = "application/json")
    @ApiOperation(value="根据id查询商品",notes = "成功：200，失败：非200")
    public Result<TbItem> getItemById(@PathVariable @ApiParam("用户id") Long id){
        if (id == 0){
//            throw  new MessageException("id不能为空或者是0");
            throw new LyException(ExceptionEnum.UPLOADIMAGE_ERROR);
        }
        log.info("shangpin de id shi:{}",id);
        return Result.ok(itemMapper.selectByPrimaryKey(id));
    }
    @GetMapping("findList")
    @ApiOperation(value="查询List",notes = "成功：200，失败：非200")
    public Result<List<TbItem>> findList(){
        List<TbItem> list = itemMapper.findList();
        if (null == list){
            System.out.println("0000000000");
        }else {
            System.out.println("111111111111");
        }
        return Result.ok(list);
    }
    @GetMapping("findList2/{price}")
    @ApiOperation(value="查询List2",notes = "成功：200，失败：非200")
    public TbItem findList2(@PathVariable("price")Long price){
       /* Map<String, Object> list2 = itemMapper.findList2();
        if (list2.get("amltomal")==null) {
            System.out.println("1111111111111");
        }*/
        TbItem tbItem = new TbItem();
        tbItem = itemMapper.findById(price);
        return tbItem;
    }

}
