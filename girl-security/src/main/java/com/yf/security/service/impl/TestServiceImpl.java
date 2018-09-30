package com.yf.security.service.impl;

import com.yf.security.service.TestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Package com.yf.security.service.impl
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/30 17:51
 */
@Service
public class TestServiceImpl implements TestService{



    @Override
    @Cacheable(value = "dictValue",key = "#key",unless="#result == null")
    public String get(String key) {
        System.out.println("进来额");
        System.out.println(key);


        return "第asda次";
    }
}
