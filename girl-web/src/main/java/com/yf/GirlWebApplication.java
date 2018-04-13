package com.yf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GirlWebApplication {
    private Logger logger = LoggerFactory.getLogger(GirlWebApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GirlWebApplication.class, args);
	}
}
