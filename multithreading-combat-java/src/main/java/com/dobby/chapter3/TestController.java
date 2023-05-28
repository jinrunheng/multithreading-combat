package com.dobby.chapter3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dooby Kim
 * @Date 2023/5/28 7:08 下午
 * @Version 1.0
 */

@RestController
@Slf4j
public class TestController {

    /**
     * 使用 Postman 模拟并发请求
     *
     * @return
     */
    @PostMapping("/test")
    public String test() {
        return "test";
    }
}
