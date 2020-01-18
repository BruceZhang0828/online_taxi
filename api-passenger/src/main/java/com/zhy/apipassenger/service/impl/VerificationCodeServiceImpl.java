package com.zhy.apipassenger.service.impl;

import com.zhy.apipassenger.service.VerificationCodeService;
import com.zhy.taxi.common.constant.IdentityConstraint;
import com.zhy.taxi.common.dto.ResponseResult;
import com.zhy.taxi.common.dto.verificationcode.VerifyCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName VerificationCodeServiceIMpl
 * @Description 验证码服务验证服务
 * @Date 2020/1/18 21:17
 * @Version 1.0
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private RestTemplate restTemplate;

    private final static String SERVICE_VERIFICATION_CODE_SERVICE  = "service-verification-code";
    @Override
    public String getCode(String phonenumber) {
        String url = "http://"+SERVICE_VERIFICATION_CODE_SERVICE+"/verify-code/generate/"+ IdentityConstraint.PASSENGER + "/"+phonenumber;
        ResponseEntity<ResponseResult> resultResponseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(null, null), ResponseResult.class);
        ResponseResult result = resultResponseEntity.getBody();
        if (result.getCode() == 1) {
            // 执行成功
            JSONObject jsonObject = JSONObject.fromObject(result.getData().toString());
            VerifyCodeResponse response = (VerifyCodeResponse)JSONObject.toBean(jsonObject, VerifyCodeResponse.class);
            return response.getCode();
        }else {

            return "";
        }
    }
}
