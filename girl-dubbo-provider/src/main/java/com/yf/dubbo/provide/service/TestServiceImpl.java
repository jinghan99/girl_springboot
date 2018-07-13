package com.yf.dubbo.provide.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yf.dubbo.api.TestService;
import com.yf.dubbo.entiy.User;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TestServiceImpl
 * @Description
 * @Date 2018/7/12 15:59
 * @Author jinghan
 * @Version 1.0
 *
 * 代码里的@Service注解是com.alibaba.dubbo.config.annotation.Service的。
 */
@Service(version = "1.0.0")
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()) + ": " + str;
    }

    @Override
    public User findUser() {
        User user = new User();
        user.setId(1001);
        user.setUsername("scott");
        user.setPassword("tiger");
        user.setAge(20);
        user.setGender(0);
        return user;


    }
}
