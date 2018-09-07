package com.yfcloud.configeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 *
 * 构建高可用的Config Server
 *
 * 依次启动config-eureka-server和config-server(config-server开启两个实例，端口号8768、8769)，
 * 成功后启动config-client。
 * 通过控制台可以看到config-client向地址为http://localhost:8768的config-server读取了配置文件，
 * 浏览器访问http://localhost:8763/foo，显示
 */
@EnableEurekaServer
@SpringBootApplication
public class ConfigEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaServerApplication.class, args);
	}
}
