package com.zhy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @ClassName EurekaApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2019/12/17 22:35
 * @Version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
