package com.yf.dubbo.controller;

import com.yf.dubbo.consumer.service.DubboTestService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DubboTestService dubboTestService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String Hello(){
        return dubboTestService.hello();
    }
}
