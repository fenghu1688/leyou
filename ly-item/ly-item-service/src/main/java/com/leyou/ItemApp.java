package com.leyou;

import com.github.xiaour.api_scanner.annotation.Sapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author fenghu
 * @description: TODO
 * @date 2018/6/18 10:12
 */
@Sapi(controllers = {"com.leyou.item.web.BrandController"})
@ServletComponentScan(basePackages = {"com.github.xiaour.api_scanner.servlet"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.leyou.item.mapper")
@EnableFeignClients
public class ItemApp {

    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class);
    }
}
