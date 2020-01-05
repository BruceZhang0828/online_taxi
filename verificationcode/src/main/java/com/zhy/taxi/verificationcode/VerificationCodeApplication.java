package com.zhy.taxi.verificationcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName VerificationCodeApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 10:57
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class VerificationCodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VerificationCodeApplication.class, args);
    }
}
