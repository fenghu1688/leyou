package com.leyou.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.ItemDescMapper;
import com.leyou.item.pojo.TbItemDesc;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/29:56
 */
@Service
public class ItemDescService {
    @Autowired
    private ItemDescMapper itemDescMapper;
    public PageResult<TbItemDesc> findItemDescListByWhere(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //开始分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(TbItemDesc.class);
        if(StringUtils.isNotBlank(key)){
            example.createCriteria().orLike("itemId","%"+key+"%").orEqualTo("itemDesc",key);
        }
        if(StringUtils.isNotBlank(sortBy)){
            //排序
            String orderByClause=sortBy+(desc ? " DESC" :" ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<TbItemDesc> list = itemDescMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
             throw new LyException(ExceptionEnum.ITEMDESC_NOT_FOUND);
        }
        //解析结果
        PageInfo pageInfo = new PageInfo(list);

        return new PageResult<>(pageInfo.getTotal(), list);

    }
    @Transactional
    public void saveItemDes( TbItemDesc itemDesc) {
        itemDescMapper.insertItemDesc(itemDesc.getItemId(),itemDesc.getItemDesc(),itemDesc.getCreated(),itemDesc.getUpdated());

    }
}
