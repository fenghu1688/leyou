package com.leyou.item.pojo;

import io.swagger.annotations.*;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/18 13:52
 */
//@Data
    @ApiModel(value = "item",description = "衣服")
public class Item  implements Comparable<Item>{
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("价格")
    private Long price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getId(), item.getId()) &&
                Objects.equals(getName(), item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public int compareTo(Item o) {
        // TODO Auto-generated method stub
        return this.id - o.id;
    }

    public Item(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
