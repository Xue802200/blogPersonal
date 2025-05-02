package com.quanxiaoha.weblog.common.enums;

import com.quanxiaoha.weblog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    //------通用异常状态码-----------------
    SYSTEM_ERROR("10000","出错啦,系统小哥正在维护当中"),

    //------业务异常状态码-----------------
    PRODUCT_NOT_FOUND("20000","该产品不存在(测试使用)"),

    //--------通用异常状态码---------------
    PARAMS_NOT_VALID("10001","传入的参数有误,请检查后重新输入");

    private final String errorCode;
    private final String errorMessage;
}
