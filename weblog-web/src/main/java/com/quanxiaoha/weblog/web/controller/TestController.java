package com.quanxiaoha.weblog.web.controller;

import com.quanxiaoha.weblog.common.utils.Response;
import com.quanxiaoha.weblog.web.model.User;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response<User> createUser(@RequestBody @Validated User user) {
        User build = User.builder()
                .username(user.getUsername())
                .age(user.getAge())
                .createTime(user.getCreateTime())
                .sex(user.getSex())
                .updateTime(user.getUpdateTime())
                .time(user.getTime())
                .build();

        return Response.success(build);
    }
}


