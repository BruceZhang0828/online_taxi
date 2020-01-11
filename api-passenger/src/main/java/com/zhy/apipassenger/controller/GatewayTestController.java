package com.zhy.apipassenger.controller;

import com.zhy.taxi.common.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GatewayTestController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/11 16:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/api-passenger-gateway-test")
public class GatewayTestController {

    @GetMapping("/hello")
    public  void helloWorld() {
        System.out.println("api-passenger-hello");
    }

    @GetMapping("/api1")
    public ResponseResult send(HttpServletRequest request) {
        String token = request.getHeader("token");
        String cookie = request.getHeader("Cookie");

        System.out.println("乘客api：token："+token);
        System.out.println("乘客api：cookie："+cookie);

        JSONObject result = new JSONObject();
        result.put("api-passenger", "乘客api接口服务");

        return ResponseResult.success(result);
    }
}
