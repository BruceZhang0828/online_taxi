package com.zhy.taxi.order.dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ServiceOrderDispatchApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:26
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceOrderDispatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderDispatchApplication.class, args);
    }
}
