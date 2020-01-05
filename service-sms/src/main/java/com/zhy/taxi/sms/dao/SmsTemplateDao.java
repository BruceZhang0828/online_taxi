package com.zhy.taxi.sms.dao;

import com.zhy.taxi.common.entity.SmsTemplate;
import com.zhy.taxi.sms.mapper.SmsTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SmsTemplateDao
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 12:37
 * @Version 1.0
 */
@Service
public class SmsTemplateDao {
    @Autowired
    private SmsTemplateMapper smsTemplateMapper;

    public SmsTemplate getByTemplateId(String id) {
        return smsTemplateMapper.selectByTemplateId(id);
    }
}
