package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author fenghu
 * @description: TODO
 * @date 2018/6/18 10:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.leyou.item.mapper")
public class ItemApp {

    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class);
    }
}
