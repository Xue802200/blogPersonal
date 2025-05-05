package com.quanxiaoha.weblog.web;

import com.quanxiaoha.weblog.common.domain.dos.UserDO;
import com.quanxiaoha.weblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class WeblogWebApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void testLog(){
        log.info("Info日志");
        log.warn("Warn日志");
        log.error("Error日志");

        //占位符
        String author = "新专辑";
        log.info("作者为" + author);
    }

    @Test
    void testUser(){
        UserDO userDO = UserDO.builder()
                .username("xzj")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();

        userMapper.insert(userDO);
    }

}
