package com.zhy.taxi.common.dto;

import com.zhy.taxi.common.constant.CommonStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName ResponseResult
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/1 21:47
 * @Version 1.0
 */
@Data
// 构建链式
@Accessors(chain = true)
@SuppressWarnings("a11")
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -2073390651767969040L;

    private int code;
    private String message;
    private T data;
    /***
     *
     * @return 
     *  返回成功数据(status : 1)
     *
     * <PRE>
     * author 搬砖的孟达
     * date 
     * </PRE>
     */
    public static <T> ResponseResult success(T d){
        return new ResponseResult().setCode(CommonStatus.SUCCESS.getCode())
                .setMessage(CommonStatus.SUCCESS.getValue())
                .setData(d);
    }


    /**
     * @return 
     * 返回错误信息
     * <PRE>
     * author 搬砖的孟达
     * date 
     * </PRE>
     */
    public static <T> ResponseResult fail(int code,String messages){
        return new ResponseResult().setCode(code)
                .setMessage(messages);
    }


    /**
     * @param code    错误代码
     * @param message 错误消息
     * @param data    错误内容
     * @return ResponseResult实例
     */
    public static ResponseResult fail(int code, String message, String data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }


}
