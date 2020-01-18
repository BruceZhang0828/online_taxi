package com.zhy.apipassenger.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhy.apipassenger.dto.ShortMsgRequest;
import com.zhy.apipassenger.service.ShortMsgService;
import com.zhy.apipassenger.service.VerificationCodeService;
import com.zhy.taxi.common.constant.CommonStatus;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.common.utils.PhoneUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SmsController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 18:23
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/sms")
@Slf4j
public class SmsController {

    @Autowired
    private ShortMsgService shortMsgService;

    @Autowired
    private VerificationCodeService verificationCodeService;


//    @HystrixCommand(fallbackMethod = "sendFail")
    @PostMapping(value = "/verify-code/send")
    public ResponseResult verifyCodeSend(@RequestBody ShortMsgRequest shortMsgRequest) {
        String phoneNumber = shortMsgRequest.getPhoneNumber();
        //校验手机号
        if (StringUtils.isBlank(phoneNumber)) {
            return ResponseResult.fail(CommonStatus.PHONENUMBER_EMPTY.getCode(), CommonStatus.PHONENUMBER_EMPTY.getValue());
        }

        if (!PhoneUtil.isPhone(phoneNumber)) {
            return ResponseResult.fail(CommonStatus.PHONENUMBER_ERROR.getCode(), CommonStatus.PHONENUMBER_ERROR.getValue());
        }

        // 获取验证码
        String code = verificationCodeService.getCode(phoneNumber);
        log.info("service-verificationCodeService-code:"+code);
        //还应有一个服务，获取验证码，临时先这么用
        // String code = "123456";
        ResponseResult responseResult = shortMsgService.send(phoneNumber, code);
        return ResponseResult.success(null);
    }


    // 熔断处理
    public ResponseResult sendFail(ShortMsgRequest shortMsgRequest) {
        // 备用逻辑
        return ResponseResult.fail(-1, "熔断处理");
    }

    @GetMapping("/getRedis")
    public String getRedis(){
        return shortMsgService.getRedis();
    }
}
