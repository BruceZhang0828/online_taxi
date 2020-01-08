package com.zhy.apipassenger.controller;

import com.zhy.taxi.common.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/8 22:28
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("/apil")
    public ResponseResult send(){
        JSONObject result = new JSONObject();
        result.put("api-passenger", "乘客api接口服务");
        return ResponseResult.success(result);
    }
}
