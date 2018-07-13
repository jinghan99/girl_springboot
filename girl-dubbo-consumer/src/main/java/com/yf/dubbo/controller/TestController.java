package com.yf.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yf.dubbo.api.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Date 2018/7/12 16:05
 * @Author jinghan
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Reference(version = "1.0.0")
    public TestService testService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String Hello(){
        return testService.sayHello("hellohello");
    }
}
