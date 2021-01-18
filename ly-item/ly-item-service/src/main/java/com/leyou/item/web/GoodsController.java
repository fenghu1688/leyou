package com.leyou.item.web;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.dto.SpuBo;
import com.leyou.item.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "goods",tags = "商品服务")
public class GoodsController{

    @Autowired
    private GoodsService goodsService;

    /**
     * 分页查询SPU
     * @param page
     * @param rows
     * @param key
     * @return
     */
    @GetMapping("/spu/page")
    @ApiOperation(value = "querySpuByPage",notes = "成功：200 非成功：非200")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @ApiParam("当前页")  @RequestParam(value = "page", defaultValue = "1") Integer page,
            @ApiParam("每页大小") @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @ApiParam("搜索关键词")  @RequestParam(value = "key", required = false) String key) {
        // 分页查询spu信息
        PageResult<SpuBo> result = this.goodsService.querySpuByPageAndSort(page, rows, true,key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
}