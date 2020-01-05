package com.zhy.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName StartApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2019/12/29 9:59
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class StartApplication {
    public static void main(String[] args) {
       SpringApplication.run(StartApplication.class,args);
    }
}
