package com.leyou.upload.controller;

import com.leyou.common.utils.Result;
import com.leyou.upload.domain.TbItem;
import com.leyou.upload.feignClient.ItemFeignClient;
import com.leyou.upload.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/39:25
 */
@RestController
@Api(value = "uploadImage",tags = "图片上传")
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "图片上传",notes = "成功：200，失败：非200")
    @PostMapping("image")
    public ResponseEntity<String> upLoadImage(@RequestParam("file") MultipartFile file){
       String url= uploadService.uploadImage(file);
       if(StringUtils.isBlank(url)){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
        return ResponseEntity.ok(url);

    }
    @Autowired
    private ItemFeignClient itemFeignClient;

    @GetMapping("/getItem/{id}")
    @ApiOperation(value="根据id查询商品",notes = "成功：200，失败：非200")
    public Result<TbItem> getItemById(@PathVariable @ApiParam("用户id") Long id){

        return itemFeignClient.getItemById(id);
    }
}
