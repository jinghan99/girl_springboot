package com.yfcloud.feignclient.exception;

import com.yfcloud.feignclient.api.EurekaClientFeignService;
import org.springframework.stereotype.Component;

/**
 * @Package com.yfcloud.feignclient.exception
 * @Description: 熔断器动作 断开连接
 * @author: jingh
 * @date 2018/9/6 16:41
 */

@Component
public class HiHystrix implements EurekaClientFeignService {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi,熔断器动作"+name+",sorry.error!";
    }
}
