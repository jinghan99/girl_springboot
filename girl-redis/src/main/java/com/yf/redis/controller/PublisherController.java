package com.yf.redis.controller;

import com.yf.redis.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yf.redis.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/6/13 22:26
 */
@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @RequestMapping("{name}")
    public String sendMessage(@PathVariable("name") String name) {
        return publisherService.sendMessage(name);
    }
}
