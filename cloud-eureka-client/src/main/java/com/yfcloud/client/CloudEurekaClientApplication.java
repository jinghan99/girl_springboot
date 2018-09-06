package com.yfcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaClientApplication.class, args);
	}
}
