package com.yfcloud.feignclient.controller;

import com.yfcloud.feignclient.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yfcloud.feignclient.controller
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/6 15:58
 */
@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "cralor", required = false) String name) {
        return hiService.sayHi(name);
    }
}
