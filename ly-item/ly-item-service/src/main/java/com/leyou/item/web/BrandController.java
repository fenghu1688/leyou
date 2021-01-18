package com.leyou.item.web;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.utils.Result;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("brand")
@Api(value = "brand",tags = "商品品牌")
public class BrandController {

    @Autowired
    private BrandService brandService;
    @Autowired
    private BrandMapper brandMapper;

    @GetMapping("page")
    @ApiOperation(value="分页查询",notes = "成功：200，失败：非200")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @ApiParam("当前页")   @RequestParam(value = "page", defaultValue = "1") Integer page,
            @ApiParam("每页大小")  @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @ApiParam("排序字段") @RequestParam(value = "sortBy", required = false) String sortBy,
            @ApiParam("是否为降序")  @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @ApiParam("搜索关键词") @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> result = this.brandService.queryBrandByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("insert")
    @ApiOperation(value="新增品牌",notes = "成功：200，失败：非200")
    public Result saveBrand(@Valid @ApiParam("品牌") Brand brand, @RequestParam("cids") List<Long> cids) {

        return  brandService.saveBrand(brand, cids);
    }

}