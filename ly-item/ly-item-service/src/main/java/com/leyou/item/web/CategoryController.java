package com.leyou.item.web;

import com.leyou.common.utils.Result;
import com.leyou.item.dto.CategoryDto;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fenghu
 * @description: 商品类目
 * @date 2019/6/1915:32
 */
@RestController
@Api(value = "category",tags = "商品类目")
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping("list")
    @ApiOperation(value = "查询List", notes = "成功：200，失败：非200")
    public Result<List<Category>> queryByParentId(@RequestParam(value = "pid", defaultValue = "0") int pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> list = this.categoryMapper.select(category);

        return Result.ok(list);
    }

    @GetMapping("listAll")
    @ApiOperation(value = "查询ListAll", notes = "成功：200，失败：非200")
    public Result<List<Category>> listAll() {

        List<Category> list = this.categoryMapper.listAll2();
        List<Category> categories = categoryMapper.selectAllOrderByParentId();

        this.tranferData(list, categories);

        return Result.ok(list);
    }

    private void tranferData(List<Category> list, List<Category> categories) {

        for (Category category : list) {
            ArrayList<Category> arrayList = new ArrayList<>();
            for (Category category1 : categories) {
                if (category1.getParentId() == category.getId()) {
                    arrayList.add(category1);
                    if (category1.getIsParent() == 1) {
                        ArrayList<Category> list1 = new ArrayList<>();
                        list1.add(category1);
                        tranferData(list1, categories);
                    }
                }

                category.setCategories(arrayList);
            }

        }
    }
}
