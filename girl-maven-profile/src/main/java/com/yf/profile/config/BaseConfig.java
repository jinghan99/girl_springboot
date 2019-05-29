package com.yf.profile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.yf.profile.config
 * @Description: TODO
 * @author: jingh
 * @date 2019/5/29 22:46
 */
@Configuration
public class BaseConfig {

    @Value("${config.type}")
    private String type;

    @Value("${spring.profiles.active}")
    private String active;

    public String getType() {
        return type;
    }

    public String getActive() {
        return active;
    }
}
