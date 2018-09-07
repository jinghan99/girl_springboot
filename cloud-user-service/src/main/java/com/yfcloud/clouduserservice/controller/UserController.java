package com.yfcloud.clouduserservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yfcloud.clouduserservice.controller
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/7 16:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hi")
    public String hi(){
        return "i'm cralor";
    }
}
