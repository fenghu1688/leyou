package com.leyou.item.web;

import com.google.common.annotations.VisibleForTesting;
import com.leyou.item.pojo.Item;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.math.BigDecimal;
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
        if (new BigDecimal("0").compareTo(new BigDecimal("0.00"))>0){
            System.out.println("111111111111");
        }else {
            System.out.println("000000000000000000");
        }
    }


}
