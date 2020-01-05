package com.zhy.taxi.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName SmsTemplate
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:59
 * @Version 1.0
 */
@Data
public class SmsTemplate {

    private Integer id;

    private String templateId;

    private String templateName;

    private String content;

    private Date createTime;

    private Date updateTime;

    private Boolean templateType;
}
