package com.zhy.apipassenger.service;

import com.zhy.taxi.common.dto.ResponseResult;

public interface ShortMsgService {
    ResponseResult send(String phoneNumber, String code);
}
