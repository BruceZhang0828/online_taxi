package com.zhy.taxi.sms.constant;

import lombok.Data;
import lombok.Getter;

public enum SmsStatusEnum {

    /**
     * 操作成功
     */
    SUCCESS(1, "success"),


    /**
     * 操作异常
     */
    INTERNAL_SERVER_EXCEPTION(0, "exception"),


    /**
     * 操作失败
     */
    FAIL(0, "fail");


    @Getter
    private final int code;

    @Getter
    private final String value;

    private SmsStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
