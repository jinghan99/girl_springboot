package com.yf.dubbo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ConsumerApplication
 * @Description
 * @Date 2018/7/12 16:08
 * @Author jinghan
 * @Version 1.0
 */
@SpringBootApplication
public class ConsumerApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.err.println("服务提供者------>>启动完毕");
    }
}
