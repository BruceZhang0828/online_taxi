package com.zhy.taxi.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName CloudAdminApplication
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/12 21:49
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class CloudAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAdminApplication.class, args);
    }
}
