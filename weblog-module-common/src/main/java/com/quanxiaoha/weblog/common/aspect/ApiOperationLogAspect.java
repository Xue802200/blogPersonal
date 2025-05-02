package com.quanxiaoha.weblog.common.aspect;

import com.quanxiaoha.weblog.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class ApiOperationLogAspect {
    //以自定义@ApiOperationLog 注解为切点 , 凡是添加@ApiOperationLog的方法,都会执行
    @Pointcut("@annotation(com.quanxiaoha.weblog.common.aspect.ApiOperationLog)")
    public void apiOperationLog() {}

    @Around("apiOperationLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //请求开始时间
            long startTime = System.currentTimeMillis();

            // MDC 为当前日志添加一个唯一的标识符
            MDC.put("traceId", UUID.randomUUID().toString());

            //获取被请求的类和方法
            String className = joinPoint.getTarget().getClass().getSimpleName();  //getTarget是获取被代理的目标对象实例   getClass是获取目标对象的Class对象     getSimpleName是获取简单的方法名
            String methodName = joinPoint.getSignature().getName();               //getSignature是获取连接点的方法签名对象   getName 是从方法签名中获取方法民名称

            //请求入参
            Object[] args = joinPoint.getArgs();
            //入参转JSON
            String argsJSON = Arrays.stream(args).map(JsonUtil::toJsonString).collect(Collectors.toList()).toString();

            //功能描述信息
            String description = getApiOperationDescriptionName(joinPoint);

            //打印请求相关参数
            log.info("----请求开始【{}】,入参:{},请求类:{},请求方法:{}----", description,argsJSON,className,methodName);

            //执行切点方法
            Object result = joinPoint.proceed();

            //执行耗时
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            //打印出参等相关信息
            log.info("----请求开始时间:{},请求结束时间:{},请求用时:{}----",startTime , endTime , executionTime);

            return result;
        } finally {
            MDC.clear();
        }
    }

    /*
    获取注解的描述信息
     */
    private String getApiOperationDescriptionName(ProceedingJoinPoint joinPoint) {
        //1.获取MethodSignature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //2.使用MethodSignature获取当前被注解的 Method
        Method method = signature.getMethod();

        //3.提取注解的相关信息
        ApiOperationLog apiOperationLog = method.getAnnotation(ApiOperationLog.class);

        //4.获取注解的description属性
        return apiOperationLog.description();
    }

}
