package com.yf.chrome;

import cn.hutool.http.HttpGlobalConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author jinghan
 * @title: ReptileServiceApplication
 * @projectName mobilepay
 * @description: 爬虫 服务
 * @date 2019/9/11 14:21
 */
@SpringBootApplication
public class ReptileChromeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReptileChromeServiceApplication.class, args);
    }

    @Component
    public class CommandLineRunnerImpl implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            HttpGlobalConfig.setTimeout(10000);
            System.out.println("启动后执行http全局超时："+ HttpGlobalConfig.getTimeout());
        }
    }
}


