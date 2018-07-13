package com.yf.dubbo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ProviderApplication
 * @Description
 * @Date 2018/7/12 16:03
 * @Author jinghan
 * @Version 1.0
 */
@SpringBootApplication
public class ProviderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.err.println("服务提供者------>>启动完毕");
    }
}

