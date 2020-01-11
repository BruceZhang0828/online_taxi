package com.zhy.taxi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * @ClassName OnlineTaxiGatewayApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/8 22:15
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class OnlineTaxiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineTaxiGatewayApplication.class, args);
    }
}
