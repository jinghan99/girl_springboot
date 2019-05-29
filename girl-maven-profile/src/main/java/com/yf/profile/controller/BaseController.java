package com.yf.profile.controller;

import com.yf.profile.config.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yf.profile.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/5/29 22:28
 */
@RestController
public class BaseController {

    @Autowired
    private BaseConfig baseConfig;


    @GetMapping("/")
    public String index(){
        return "当前环境："+baseConfig.getActive()+"，常用type ："+baseConfig.getType();
    }
}
