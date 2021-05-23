package org.wq.spring_security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author WangQian
 * @Date 2021/5/20 下午 2:53
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello-" + new Date();
    }

    @RequestMapping("/s")
    public String success(){
        return "Success-" + new Date();
    }

    @RequestMapping("/f")
    public String fail(){
        return "fail-" + new Date();
    }
}
