package com.zhy.taxi.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName OnlineTaxiConfigServerApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/11 20:35
 * @Version 1.0
 */
@EnableConfigServer
@SpringBootApplication
public class OnlineTaxiConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineTaxiConfigServerApplication.class, args);
    }
}
