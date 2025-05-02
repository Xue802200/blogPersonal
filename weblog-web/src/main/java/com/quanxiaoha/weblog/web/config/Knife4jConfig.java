//package com.quanxiaoha.weblog.web.config;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Knife4jConfig {
//
//
//    @Bean("webApi")
//    public Docket createApiDoc() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(buildApiInfo())
//                .groupName("Web 前台接口")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.quanxiaoha.weblog.web.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 构建 API 信息
//     * @return ApiInfo
//     */
//    private ApiInfo buildApiInfo() {
//        return new ApiInfoBuilder()
//                .title("Weblog 博客前台接口文档")
//                .description("Weblog 是一款由 Spring Boot + Vue 3.2 + Vite 4.3 开发的前后端分离博客。")
//                .termsOfServiceUrl("https://www.quanxiaoha.com/")
//                .contact(new Contact("犬小哈", "https://www.quanxiaoha.com", "871361652@qq.com"))
//                .version("1.0")
//                .build();
//    }
//}
