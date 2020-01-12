package com.zhy.taxi.verificationcode.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName ConfigController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/12 9:20
 * @Version 1.0
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${env}")
    private String env;

    @GetMapping("/env")
    public String env() {
        return "env:"+env;
    }
}
