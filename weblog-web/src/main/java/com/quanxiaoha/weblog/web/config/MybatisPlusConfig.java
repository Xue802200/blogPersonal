package com.quanxiaoha.weblog.web.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.quanxiaoha.weblog.common.domain.mapper")
public class MybatisPlusConfig {
}
