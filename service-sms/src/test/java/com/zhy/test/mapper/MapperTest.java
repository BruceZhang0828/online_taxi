package com.zhy.test.mapper;

import com.zhy.taxi.common.entity.SmsTemplate;
import com.zhy.taxi.sms.ServiceSmsApplication;
import com.zhy.taxi.sms.mapper.SmsTemplateMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName MapperTest
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 21:07
 * @Version 1.0
 */
@SpringBootTest(classes = ServiceSmsApplication.class)
@RunWith(SpringRunner.class)
public class MapperTest {

    @Autowired
    SmsTemplateMapper smsTemplateMapper;
    @Test
    public  void test_selectByTemplateId(){
        SmsTemplate smsTemplate = smsTemplateMapper.selectByTemplateId("sms");
        System.out.println(smsTemplate);

    }
}
