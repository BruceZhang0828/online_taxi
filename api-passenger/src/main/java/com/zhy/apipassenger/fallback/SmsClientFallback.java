package com.zhy.apipassenger.fallback;

import com.zhy.apipassenger.service.SmsClient;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.common.dto.sms.SmsSendRequest;
import org.springframework.stereotype.Component;

/**
 * @ClassName SmsClientFallback
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 22:39
 * @Version 1.0
 */
@Component
public class SmsClientFallback implements SmsClient {
    @Override
    public ResponseResult sendSms(SmsSendRequest smsSendRequest) {
        System.out.println("进行熔断...");
        return null;
    }
}
