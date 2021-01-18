package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author fenghu
 * @description: eureka服务端
 * @date 2019/6/16 23:41
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApp {
    public static void main(String[] args) {
        SpringApplication.run(RegistryApp.class);
    }
}
