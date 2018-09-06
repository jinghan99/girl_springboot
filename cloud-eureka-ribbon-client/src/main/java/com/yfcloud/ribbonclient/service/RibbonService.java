package com.yfcloud.ribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Package com.yfcloud.ribbonclient.service
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/6 15:31
 */

@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;


    public String hi(String name){

        /**
         * 写一个RESTful API接口，调用eureka－client的API接口“/hi”，即消费服务。
         * 由于eureka-client为两个实例（端口8762、8763），在调用时希望做到轮流访问这两个实例，
         * 这时需要将RestTemplate和Ribbon结合进行负载均衡。只需要在程序的IOC容器中注入一个restTemplate的Bean，
         * 并加上@LoadBalanced注解，此时RestTemplate就结合了Ribbon开启了负载均衡功能。
         */
//        uri上不需要使用硬编码（如IP地址），只需写服务名eureka-client即可
        return restTemplate.getForObject("http://service-hi/hello?name="+name,String.class);
    }
}
