package com.zhy.taxi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ServiceAppUpdateApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 11:05
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceAppUpdateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAppUpdateApplication.class, args);
    }
}
