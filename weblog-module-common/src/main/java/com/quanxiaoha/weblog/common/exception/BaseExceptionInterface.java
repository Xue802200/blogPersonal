package com.quanxiaoha.weblog.common.exception;

/**
 *  基础异常接口
 */
public interface BaseExceptionInterface {

    //获取异常状态的验证码
    String getErrorCode();

    //获取异常的错误信息
    String getErrorMessage();

}
