package com.yf.consumer.controller;

import com.yf.consumer.producer.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yf.mq.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/8/22 23:11
 */
@RestController
public class TestController {

    @Autowired
    private RabbitProducer rabbitProducer;

    @RequestMapping("/")
    public String index(){
        rabbitProducer.stringSend();
        return "ok";
    }
}
