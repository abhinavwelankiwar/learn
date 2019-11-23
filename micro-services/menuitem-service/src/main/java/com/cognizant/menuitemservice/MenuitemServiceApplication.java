package com.cognizant.menuitemservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MenuitemServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuitemServiceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MenuitemServiceApplication.class, args);
		
		LOGGER.info("Inside  MenuitemServiceApplication main");
	}

}
