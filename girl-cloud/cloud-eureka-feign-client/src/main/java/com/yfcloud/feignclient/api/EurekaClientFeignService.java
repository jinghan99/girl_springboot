package com.yfcloud.feignclient.api;

import com.yfcloud.feignclient.config.FeignConfig;
import com.yfcloud.feignclient.exception.HiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Package com.yfcloud.feignclient.service
 * @author: jingh
 * @date 2018/9/6 15:55
 * 新建一个EurekaClientFeign的接口，在接口上加@FeignClient注解来声明一个Feign Client。
 * value为远程调用其他服务的服务名，FeignConfig.class为配置类，
 * 在EurekaClientFeign内部有一个sayHiFromClientEureka()的方法，该方法通过Feign来调用eureka-client服务的“/hi”的aipi接口。
 */

@Component
@FeignClient(value = "service-hi", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaClientFeignService {

    @GetMapping(value = "/hello")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
