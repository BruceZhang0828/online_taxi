package com.zhy.taxi.verificationcode.request;

import lombok.Data;

/**
 * @ClassName CodeVerifyRequest
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/12 17:50
 * @Version 1.0
 */
@Data
public class CodeVerifyRequest {
    private String phonenumber;

    private String code;
}
