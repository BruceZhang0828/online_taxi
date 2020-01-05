package com.zhy.taxi.sms.mapper;

import com.zhy.taxi.common.entity.SmsTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsTemplate record);

    int insertSelective(SmsTemplate record);

    SmsTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsTemplate record);

    int updateByPrimaryKey(SmsTemplate record);

    SmsTemplate selectByTemplateId(String templateId);
}