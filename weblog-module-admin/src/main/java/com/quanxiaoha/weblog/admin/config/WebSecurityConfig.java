package com.quanxiaoha.weblog.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/admin/**").authenticated()    //认证所有以 /admin为前缀
                .anyRequest().permitAll().and() //其他都需要放行,无需认证
                .formLogin().and() //使用表单登录
                .httpBasic();     //使用HTTP Basic认证
    }
}
