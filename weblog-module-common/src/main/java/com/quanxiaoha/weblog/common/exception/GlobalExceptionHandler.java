package com.quanxiaoha.weblog.common.exception;


import com.quanxiaoha.weblog.common.enums.ResponseCodeEnum;
import com.quanxiaoha.weblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 处理自定义异常类
     * @param httpServletRequest        请求信息
     * @param bizException              异常的类型
     * @return                          异常半身
     */
    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest httpServletRequest, BizException bizException){
        log.warn("请求url:{} , 请求失败响应状态码:{} , 请求失败响应信息:{}", httpServletRequest.getRequestURI(), bizException.getErrorCode(), bizException.getErrorMessage());
        return Response.fail(bizException);
    }

    /**
     * 处理其他异常
     * @param httpServletRequest        请求信息
     * @param exception                 异常的类型
     * @return                          枚举类的系统错误
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest httpServletRequest , Exception exception){
        log.warn("请求url:{},请求错误信息:{}", httpServletRequest.getRequestURI(), exception.getMessage());
        return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }


    /**
     * 捕获参数校验异常
     * @param httpServletRequest        请求体
     * @param exception                 异常信息
     * @return                          枚举类的错误类型
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest httpServletRequest, MethodArgumentNotValidException exception){
        //参数错误异常状态码
        String errorCode = ResponseCodeEnum.PARAMS_NOT_VALID.getErrorCode();

        //获取BindingResult
        BindingResult bindingResult = exception.getBindingResult();

        StringBuffer stringBuffer = new StringBuffer();
        //自定义返回错误信息 , eg:邮箱输入格式有错误 ,当前的值为:1234
        bindingResult.getFieldErrors().forEach(fieldError -> {
            stringBuffer
                    .append("请求的地址为")
                    .append(httpServletRequest.getRequestURI())
                    .append(",错误原因为:")
                    .append(fieldError.getDefaultMessage())
                    .append(",当前填写的值为:")
                    .append(fieldError.getField())
                    .append(":")
                    .append(fieldError.getRejectedValue());

        });

        //转为String,用于返回数据
        String errMessage = stringBuffer.toString();

        return Response.fail(errMessage,errorCode);
    }
}
