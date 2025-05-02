package com.quanxiaoha.weblog.common.aspect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API功能描述
     *
     * @return 返回
     */
    String description() default "";
}
