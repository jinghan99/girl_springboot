package com.yfcloud.feignclient.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Package com.yfcloud.feignclient.config
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/6 15:56
 * <p>
 * 在FeignConfig类上加上@Configuration注解，表明这是一个配置类，
 * 并注入一个BeanName为feignRetryer的Retryer的Bean。可使feign在远程调用失败后会进行重试。
 */

@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}
