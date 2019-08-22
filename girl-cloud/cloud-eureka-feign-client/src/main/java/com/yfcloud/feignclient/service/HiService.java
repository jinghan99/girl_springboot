package com.yfcloud.feignclient.service;

import com.yfcloud.feignclient.api.EurekaClientFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package com.yfcloud.feignclient.service
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/6 15:57
 */
@Service
public class HiService {

    @Autowired
    EurekaClientFeignService eurekaClientFeignService;

    public String sayHi(String name) {
        return eurekaClientFeignService.sayHiFromClientEureka(name);
    }
}
