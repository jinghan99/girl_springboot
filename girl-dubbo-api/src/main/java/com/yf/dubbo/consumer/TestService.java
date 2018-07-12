package com.yf.dubbo.consumer;

import com.yf.dubbo.entiy.User;

/**
 * @ClassName TestService
 * @Description
 * @Date 2018/7/12 15:55
 * @Author jinghan
 * @Version 1.0
 */
public interface TestService {
    String sayHello(String str);

    User findUser();
}
