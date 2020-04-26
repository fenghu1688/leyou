package com.leyou.item.web;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.TbItemDesc;
import com.leyou.item.service.ItemDescService;
import com.leyou.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/29:55
 */
@RestController
@RequestMapping("item")
public class ItemDescController {
    @Autowired
    private ItemDescService itemDescService;

    @PostMapping("list")
    public ResponseEntity<PageResult<TbItemDesc>> findItemDescListByWhere(
            @RequestParam(value = "page",defaultValue = "2") Integer page,
            @RequestParam(value = "rows",defaultValue = "5")  Integer rows,
            @RequestParam(value = "sortBy",required = false)  String sortBy,
            @RequestParam(value = "desc",defaultValue = "false")  Boolean desc,
            @RequestParam(value = "key",required = false)  String key
    ){
        PageResult<TbItemDesc> pageResult=itemDescService.findItemDescListByWhere(page,rows,sortBy,desc,key);
        if(pageResult==null || pageResult.getItems().size()== 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("save")
    public ResponseEntity<Void> saveItemDes( @RequestBody TbItemDesc tbItemDesc){
        itemDescService.saveItemDes(tbItemDesc);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
