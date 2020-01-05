package com.zhy.taxi.sms.dao;

import com.zhy.taxi.common.entity.Sms;
import com.zhy.taxi.sms.mapper.SmsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SmsDao
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 12:37
 * @Version 1.0
 */
@Service
public class SmsDao {
    @Autowired
    private SmsMapper smsMapper;

    public int insert(Sms sms) {

        return smsMapper.insertSelective(sms);
    }
}
