package com.zhy.apipassenger.service;

/**
 * 验证码服务
 */
public interface VerificationCodeService {
    /**
     * 获取验证码
     * @param phonenumber
     * @return
     */
    String getCode(String phonenumber);


}
