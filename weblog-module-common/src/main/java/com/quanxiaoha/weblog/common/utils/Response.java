package com.quanxiaoha.weblog.common.utils;

import com.quanxiaoha.weblog.common.exception.BaseExceptionInterface;
import com.quanxiaoha.weblog.common.exception.BizException;
import lombok.Data;

import java.io.Serializable;

/**
 * 自定义响应结果类
 * @param <T>
 */
@Data
public class Response<T> implements Serializable {

    //是否成功 , 默认为true
    private Boolean success = true;
    //响应消息
    private String message;
    //异常码
    private String errorCode;
    //响应数据
    private T data;

    //-----------------------响应成功返回------------------------------
    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<T>();
        response.setData(data);

        return response;
    }

    //----------------------响应成功---------------------------------
    public static <T> Response<T> success(){
        return new Response<T>();
    }

    //-----------------------响应失败-----------------------------------
    public static <T> Response<T> fail(String message) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMessage(message);

        return response;
    }

    //------------------------响应失败-------------------------------------
    public static <T> Response<T> fail(String message, String errorCode) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setErrorCode(errorCode);

        return response;
    }

    //---------------------全局异常处理的响应失败BizException----------------------
    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setErrorCode(bizException.getErrorCode());
        response.setMessage(bizException.getErrorMessage());
        return response;
    }

    //---------------------全局异常处理的响应失败,支持形参为枚举--------------------------
    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMessage(baseExceptionInterface.getErrorMessage());
        response.setErrorCode(baseExceptionInterface.getErrorCode());
        return response;
    }
}
