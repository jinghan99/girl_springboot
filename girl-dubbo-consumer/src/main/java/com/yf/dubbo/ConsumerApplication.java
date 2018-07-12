package com.yf.dubbo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName ConsumerApplication
 * @Description
 * @Date 2018/7/12 16:08
 * @Author jinghan
 * @Version 1.0
 */
@SpringBootApplication
@ImportResource({"classpath:config/spring-dubbo.xml"})
public class ConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.err.println("服务调用者------>>启动完毕");
    }
}
