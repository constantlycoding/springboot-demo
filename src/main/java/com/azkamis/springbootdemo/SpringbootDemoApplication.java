package com.azkamis.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	private final static Logger logger = LoggerFactory.getLogger(SpringbootDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
		logger.info("info!");
	}

}
