package com.zhy.taxi.sms.service.impl;

import com.zhy.taxi.common.dto.sms.SmsSendRequest;
import com.zhy.taxi.common.dto.sms.SmsTemplateDto;
import com.zhy.taxi.common.entity.Sms;
import com.zhy.taxi.common.entity.SmsTemplate;
import com.zhy.taxi.sms.constant.SmsStatusEnum;
import com.zhy.taxi.sms.dao.SmsDao;
import com.zhy.taxi.sms.dao.SmsTemplateDao;
import com.zhy.taxi.sms.service.AliService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AliServiceImpl
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/5 15:01
 * @Version 1.0
 */
@Service
@Slf4j
public class AliServiceImpl implements AliService {

    //缓存用于替换内容的模板
    private Map<String, String> templateMaps = new HashMap<>();

    @Autowired
    private SmsTemplateDao smsTemplateDao;

    @Autowired
    private SmsDao smsDao;

    @Override
    public int sendSms(SmsSendRequest request) {
        log.info(request.toString());

        for (String phoneNumber : request.getReceivers()) {
            List<SmsTemplateDto> templates = request.getData();

            Sms sms = new Sms();

            sms.setPhoneNumber(phoneNumber);

            for (SmsTemplateDto smsTemplateDto : templates) {
                // 从DB加载模板到缓存

                if (!templateMaps.containsKey(smsTemplateDto.getId())) {
                    SmsTemplate smsTemplate = smsTemplateDao.getByTemplateId(smsTemplateDto.getId());

                    System.out.println(smsTemplate.getContent());

                    templateMaps.put(smsTemplateDto.getId(), smsTemplate.getContent());
                }
                // 替换占位符
                String content = templateMaps.get(smsTemplateDto.getId());
                for (Map.Entry<String, Object> entry : smsTemplateDto.getTemplateMap().entrySet()) {
                    content = StringUtils.replace(content, "${" + entry.getKey() + "}", "" + entry.getValue());
                }

                try {
                    int result = send(phoneNumber, smsTemplateDto.getId(), smsTemplateDto.getTemplateMap());

                    sms.setSendTime(new Date());
                    sms.setOperator("");
                    sms.setSendFlag(1);
                    sms.setSendNumber(0);
                    sms.setSmsContent(content);

                    if (result != SmsStatusEnum.SUCCESS.getCode()) {
                        throw new Exception("短信发送失败");
                    }
                } catch (Exception e) {
                    sms.setSendFlag(0);
                    sms.setSendNumber(1);
                    log.error("发送短信(" + smsTemplateDto.getId() + "),失败: " + phoneNumber, e);
                } finally {
                    sms.setCreateTime(new Date());
                    smsDao.insert(sms);
                }
            }
        }
        return 0;
    }

    private int send(String phoneNumber, String id, Map<String, Object> templateMap) {

        JSONObject param = new JSONObject();
        param.putAll(templateMap);
        return smsMsg(phoneNumber, id, param);
    }

    private int smsMsg(String phoneNumber, String id, JSONObject param) {

       /* try {
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");

            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();


            //必填:待发送手机号
            request.setPhoneNumbers(phoneNumber);
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(sign);
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(param);
            //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");

            //hint 此处可能会抛出异常，注意catch
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            log.info("短信结果："+JSONObject.fromObject(sendSmsResponse));
            // 解析发送结果

            if (sendSmsResponse != null && sendSmsResponse.getCode().trim().equals("OK")) {
                System.out.println(sendSmsResponse.getBizId());
                log.info("阿里短信通道 成功 - 手机号码 - " + phoneNumber + " 内容 " + param);
                return SmsEnum.OK.getCode();
            } else {
                log.info("阿里短信通道 失败 - 手机号码 - " + phoneNumber + " 内容 " + param);
                return SmsEnum.FAIL.getCode();
            }
        } catch (Exception e) {
            return SmsEnum.EXCEPTION.getCode();
        }*/

        return SmsStatusEnum.SUCCESS.getCode();

    }
}
