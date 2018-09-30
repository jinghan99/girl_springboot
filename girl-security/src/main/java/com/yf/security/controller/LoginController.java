package com.yf.security.controller;

import com.yf.security.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package com.yf.controller
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/21 11:06
 */
@Controller
public class LoginController {


    @Autowired
    private RedisUtils redisUtils;


    @RequestMapping("/login")
    @ResponseBody
    public String login(ModelMap map) {
        redisUtils.setStr("my","你是个好人");


        return redisUtils.getStr("my");
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
