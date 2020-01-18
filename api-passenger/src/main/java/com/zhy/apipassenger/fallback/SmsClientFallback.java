package com.zhy.apipassenger.fallback;

import com.zhy.apipassenger.service.SmsClient;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.common.dto.sms.SmsSendRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SmsClientFallback
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 22:39
 * @Version 1.0
 */
@Component
public class SmsClientFallback implements SmsClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public ResponseResult sendSms(SmsSendRequest smsSendRequest) {
        System.out.println("进行熔断...");
        String key = "service-sms";
        String noticeString = redisTemplate.opsForValue().get(key);

        if (StringUtils.isBlank(noticeString)) {
            // 进行熔断通知
            System.out.println("熔断了...");
            redisTemplate.opsForValue().set(key,"notice",30, TimeUnit.SECONDS);
        }else{
            System.out.println("通知通过了,我先不通知了");
        }
        return null;
    }
}
