package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka 提供接口使用
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication2.class, args);
	}
}
