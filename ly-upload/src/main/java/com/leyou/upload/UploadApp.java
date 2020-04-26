package com.leyou.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/39:13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class UploadApp {
    public static void main(String[] args) {
        SpringApplication.run(UploadApp.class);
    }
}
