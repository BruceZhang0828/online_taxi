package com.zhy.apipassenger.service.impl;


import com.zhy.apipassenger.service.ShortMsgService;
import com.zhy.apipassenger.service.SmsClient;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.common.dto.sms.SmsSendRequest;
import com.zhy.taxi.common.dto.sms.SmsTemplateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ShortMsgServiceImpl
 * @Description 用户端发送短信API
 * @Date 2020/1/5 18:30
 * @Version 1.0
 */
@Service
public class ShortMsgServiceImpl implements ShortMsgService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SmsClient smsClient;

    @Override
    public ResponseResult send(String phoneNumber, String code) {
        System.out.println("手机号码是" + phoneNumber + "," + code);

        String url = "http://service-sms/send/alisms-template";

        SmsSendRequest smsSendRequest = new SmsSendRequest();

        String[] phoneNumbers = new String[]{phoneNumber};

        smsSendRequest.setReceivers(phoneNumbers);

        List<SmsTemplateDto> data = new ArrayList<>();

        SmsTemplateDto smsTemplateDto = new SmsTemplateDto();

        smsTemplateDto.setId("SMS_144145499");

        Map<String, Object> templateMap = new HashMap<>();
        templateMap.put("code", code);
        smsTemplateDto.setTemplateMap(templateMap);
        data.add(smsTemplateDto);
        smsSendRequest.setData(data);
//        ResponseEntity<ResponseResult> entity = restTemplate.postForEntity(url, smsSendRequest, ResponseResult.class);
        ResponseResult responseResult = smsClient.sendSms(smsSendRequest);
        System.out.println(responseResult);
        return null;
    }
}
