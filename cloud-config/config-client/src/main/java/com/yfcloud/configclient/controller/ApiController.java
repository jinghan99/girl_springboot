package com.yfcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yfcloud.configclient.controller
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/7 14:09
 *
 * 在config-client工程写一个API测试接口，读取配置文件的foo变量并返回。
 *
 *使用Spring Cloud Bus刷新配置
 * 在需要更新的配置类上加@RefreshScope注解，
 * ，@RefreshScope必须加，否则客户端会收到服务端的更新消息，但是更新不了，因为不知道更新哪里的。
 */
@RefreshScope
@RestController
public class ApiController {

    @Value("${foo}")
    String foo;

    @RequestMapping("/foo")
    public String foo(){
        return foo;
    }
}
