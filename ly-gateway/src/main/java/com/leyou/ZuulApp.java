package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/6/1623:52
 */
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }
}
