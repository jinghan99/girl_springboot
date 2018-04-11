package com.yf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class GirlApplication {
    private Logger logger = LoggerFactory.getLogger(GirlApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
