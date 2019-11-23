package com.cognizant.authenticationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
		
		LOGGER.info("Inside  AuthenticationServiceApplication main");
		
	}

}
