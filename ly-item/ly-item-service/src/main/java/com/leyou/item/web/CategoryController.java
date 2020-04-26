package com.leyou.item.web;

import com.leyou.item.pojo.Category;
import com.leyou.item.pojo.TbContentCategory;
import com.leyou.item.service.CategoryServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1915:32
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryServie categoryServie;

    @GetMapping("list")
    public ResponseEntity<List<TbContentCategory>> getListCategoryByPid () {

        return ResponseEntity.ok(categoryServie.getListCategoryByPid());
    }

    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
// 预期大于 3，结果是 3
        System.out.println(ary.length);
    }


}
