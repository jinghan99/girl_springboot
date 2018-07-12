package com.yf.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yf.dubbo.entiy.User;
import org.springframework.stereotype.Component;

/**
 * @ClassName DubboTestService
 * @Description
 * @Date 2018/7/12 17:05
 * @Author jinghan
 * @Version 1.0
 */
@Component
public class DubboTestService {

    @Reference()
    public TestService testService;

    public String hello() {
        return testService.sayHello("Hello springboot and dubbo!");
    }

    public User user() {
        return testService.findUser();
    }
}

