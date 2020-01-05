package com.zhy.taxi.common.dto.sms;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName SmsTemplateDto
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:56
 * @Version 1.0
 */
@Data
public class SmsTemplateDto {
    private String id;

    private Map<String, Object> templateMap;

    @Override
    public String toString() {
        return "SmsTemplateDto [id=" + id + ", templateMap=" + templateMap + "]";
    }
}
