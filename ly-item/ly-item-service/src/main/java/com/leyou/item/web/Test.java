package com.leyou.item.web;

import com.leyou.item.pojo.Item;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @author fenghu
 * @description: TODO
 * @date 2020-01-0320:22
 */
public class Test {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item(1, "guyuhan", 111L), new Item(2, "fenghu", 222L));
        List<String> collect = items.stream().map(item -> item.getName()).collect(Collectors.toList());
        System.out.println(collect);
        HashMap<String, Item> map = new HashMap<>();
        map.put("1",new Item(1, "guyuhan", 111L));
        map.put("2",new Item(2, "fenghu", 222L));
        String contains = "1";

   /*     map.entrySet().stream().filter(entry -> (
                ! entry.getValue().contains(contains)
        )).collect(Collectors.toMap(
                entry1 -> entry1.getKey(),
                entry2 -> entry2.getValue()

        ));*/
    }
    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

}
