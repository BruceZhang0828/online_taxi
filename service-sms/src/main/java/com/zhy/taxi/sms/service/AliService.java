package com.zhy.taxi.sms.service;

import com.zhy.taxi.common.dto.sms.SmsSendRequest;

public interface AliService {

    int sendSms(SmsSendRequest request);
}
