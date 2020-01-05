package com.zhy.taxi.common.dto.sms;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SmsSendRequest
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:56
 * @Version 1.0
 */
@Data
public class SmsSendRequest {
    private String[] receivers;
    private List<SmsTemplateDto> data;
    @Override
    public String toString() {
        return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
    }
}
