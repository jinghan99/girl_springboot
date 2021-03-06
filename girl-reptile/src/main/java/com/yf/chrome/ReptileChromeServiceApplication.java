package com.yf.chrome;

import cn.hutool.http.HttpGlobalConfig;
import cn.hutool.json.JSON;
import com.yf.chrome.scheduled.BtScheduled;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author jinghan
 * @title: ReptileServiceApplication
 * @projectName mobilepay
 * @description: 爬虫 服务
 * @date 2019/9/11 14:21
 */
@MapperScan(value = "com.yf.chrome.mapper")
@SpringBootApplication
@Slf4j
@EnableScheduling
public class ReptileChromeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReptileChromeServiceApplication.class, args);
    }

    @Component
    public class CommandLineRunnerImpl implements CommandLineRunner {

        @Autowired
        private BtScheduled btScheduled;

        @Override
        public void run(String... args) throws Exception {
            HttpGlobalConfig.setTimeout(10000);
            log.info("启动后执行http全局超时：" + HttpGlobalConfig.getTimeout());
            btScheduled.btScheduled();
        }
    }
}


