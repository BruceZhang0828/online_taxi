package com.zhy.apipassenger.controller;

import com.zhy.apipassenger.dto.ShortMsgRequest;
import com.zhy.apipassenger.service.ShortMsgService;
import com.zhy.taxi.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SmsController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 18:23
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/sms")
public class SmsController {

    @Autowired
    private ShortMsgService shortMsgService;


    @PostMapping(value = "/send")
    public ResponseResult send(@RequestBody ShortMsgRequest shortMsgRequest) {
        String phoneNumber = shortMsgRequest.getPhonenumber();
        //还应有一个服务，获取验证码，临时先这么用
        String code = "123456";
        ResponseResult responseResult = shortMsgService.send(phoneNumber, code);
        return null;
    }
}
