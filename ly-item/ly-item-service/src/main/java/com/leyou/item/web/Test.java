package com.leyou.item.web;

import com.google.common.annotations.VisibleForTesting;
import com.leyou.item.pojo.Item;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
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
        String msg = "a|b||c";
        msg = null;
        System.out.println(msg);
      /*  String[] split = msg.split("[|]", -1);
        for (String s : split) {
            if (StringUtils.isBlank(s)){
                System.out.println("1");
            }
            System.out.println(s);
        }*/
    }


}
