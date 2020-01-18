package com.zhy.taxi.common.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PhoneUtil
 * @Description 手机号工具类
 * @Date 2020/1/18 21:44
 * @Version 1.0
 */
public class PhoneUtil {

    private static final String PHONE_REFEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";


    public static boolean isPhone(String phone){

        if (StringUtils.isBlank(phone)){
            return false;
        }

        phone = phone.trim();

        if (phone.length()!=11){
            return false;
        }else {
            Pattern p = Pattern.compile(PHONE_REFEX);
            Matcher matcher = p.matcher(phone);
            boolean isMatch = matcher.matches();
            if (!isMatch) {
                return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println(isPhone("jjjjjjjjjjj"));
    }
}
