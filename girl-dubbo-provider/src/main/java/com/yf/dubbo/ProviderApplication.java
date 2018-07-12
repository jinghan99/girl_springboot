package com.yf.dubbo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ProviderApplication
 * @Description
 * @Date 2018/7/12 16:03
 * @Author jinghan
 * @Version 1.0
 */
@SpringBootApplication
public class ProviderApplication implements CommandLineRunner {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ProviderApplication.class, args);
        TimeUnit.MINUTES.sleep(10); //提供者main线程暂停10分钟等待被调用
        System.err.println("服务提供者------>>服务关闭");
    }

    @Override
    public void run(String... strings) throws Exception {
        System.err.println("服务提供者------>>启动完毕");
    }
}

