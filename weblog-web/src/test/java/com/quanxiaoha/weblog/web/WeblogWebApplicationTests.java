package com.quanxiaoha.weblog.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WeblogWebApplicationTests {

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

}
