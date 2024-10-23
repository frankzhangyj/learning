package com.microsoft.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author frank
 * @Date 2024/10/18
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        return "hello spring boot";
    }
}
