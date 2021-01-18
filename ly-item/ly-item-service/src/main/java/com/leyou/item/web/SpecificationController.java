package com.leyou.item.web;

import com.leyou.common.utils.Result;
import com.leyou.item.mapper.SpecificationMapper;
import com.leyou.item.pojo.Specification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spec")
@Api(value = "specification",tags = "商品分类模板")
public class SpecificationController {

    @Autowired
    private SpecificationMapper specificationMapper;

    @GetMapping("{id}")
    @ApiOperation(value = "根据分类id查询模板", notes = "成功：200，失败：非200")
    public Result<String> querySpecificationByCategoryId(@ApiParam("模板id") @PathVariable("id") Long id){
        Specification specification = new Specification();
        specification.setCategoryId(id);
        Specification spec = specificationMapper.selectByPrimaryKey(specification);
    /*    if (spec == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return Result.ok(spec.getSpecifications());
    }
}