package com.yf.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 应用启动器
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年9月3日 上午1:53:12
 */
@EnableCaching
@SpringBootApplication
public class GirlApplication {
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }
}
