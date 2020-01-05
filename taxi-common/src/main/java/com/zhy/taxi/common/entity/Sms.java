package com.zhy.taxi.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Sms
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:58
 * @Version 1.0
 */
@Data
public class Sms {

    private Integer id;

    private String phoneNumber;

    private String smsContent;

    private Date sendTime;

    private String operator;

    private Integer sendFlag;

    private Integer sendNumber;

    private Date createTime;

    private Date updateTime;
}
