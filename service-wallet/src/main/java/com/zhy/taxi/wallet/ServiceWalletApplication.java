package com.zhy.taxi.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ServiceWalletApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceWalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceWalletApplication.class, args);
    }
}
