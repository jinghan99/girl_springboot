package com.yfcloud.ribbonclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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


    /**
     * 修改RibbonService代码，在hi()方法上加上@HystrixCommand注解。有了该注解hi()方法就启用了Hystrix熔断器的功能，
     * 其中，fallbackMethod为处理回退（fallback）逻辑的方法。在本例子，直接返回了一个字符串。
     * 在熔断器打开的状态下，会执行fallback逻辑。fallback的逻辑最好是返回一些静态的字符串，不需要处理复杂的逻辑，
     * 也不会远程调用其他服务，这样方便执行快速失败，释放线程资源。
     * 如果一定要在fallback逻辑中远程调用其他服务，最好在远程调用其他服务时，也加上熔断器。
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name) {

        /**
         * 写一个RESTful API接口，调用eureka－client的API接口“/hello”，即消费服务。
         * 由于eureka-client为两个实例（端口8762、8763），在调用时希望做到轮流访问这两个实例，
         * 这时需要将RestTemplate和Ribbon结合进行负载均衡。只需要在程序的IOC容器中注入一个restTemplate的Bean，
         * 并加上@LoadBalanced注解，此时RestTemplate就结合了Ribbon开启了负载均衡功能。
         *  uri上不需要使用硬编码（如IP地址），只需写服务名eureka-client即可
         *
         */
        return restTemplate.getForObject("http://service-hi/hello?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi,熔断器已打开：" + name + ",sorry,error!";
    }
}
