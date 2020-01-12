package com.zhy.taxi.verificationcode.controller;

import com.zhy.taxi.common.constant.CommonStatus;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.verificationcode.constant.VerifyCodeConstant;
import com.zhy.taxi.verificationcode.request.CodeVerifyRequest;
import com.zhy.taxi.verificationcode.response.VerifyCodeResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName VerifyCodeController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/12 17:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/verify-code")
public class VerifyCodeController {
    private RedisTemplate<String,String>  redisTemplate;

    public ResponseResult<VerifyCodeResponse> generat(@PathVariable("phoneeNumber") String phoneeNumber){
        // 生成6位code
        String code = String.valueOf((int)((Math.random()*9+1)*100000));
        // 生成redis key
        String key = VerifyCodeConstant.PASSENGER_LOGIN_KEY + phoneeNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        codeRedis.set(code);
        // 设置两分钟过期
        codeRedis.expire(120, TimeUnit.SECONDS);
        // 构建返回的数据
        VerifyCodeResponse result = new VerifyCodeResponse();
        result.setCode(code);
        return ResponseResult.success(result);
    }

    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody CodeVerifyRequest request){
        String code = request.getCode();
        String phonenumber = request.getPhonenumber();
        // 构建redis的key
        String key = VerifyCodeConstant.PASSENGER_LOGIN_KEY+phonenumber;
        BoundValueOperations<String, String> redisMap = redisTemplate.boundValueOps(key);
        String redisCode = redisMap.get();
        if (StringUtils.isNotBlank(redisCode)
                &&StringUtils.isNotBlank(code)
                &&redisCode.trim().equals(code.trim())){
            return ResponseResult.success(null);
        }

        return ResponseResult.fail(CommonStatus.VERIFY_CODE_ERROR.getCode(), CommonStatus.VERIFY_CODE_ERROR.getValue());
    }
}
