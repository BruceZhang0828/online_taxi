package com.zhy.apipassenger.service;

import com.sun.org.omg.CORBA.RepositoryIdSeqHelper;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.common.dto.sms.SmsSendRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-sms")
public interface SmsClient {
    @RequestMapping(value="/send/alisms-template", method = RequestMethod.POST)
    public ResponseResult sendSms(@RequestBody SmsSendRequest smsSendRequest);
}
