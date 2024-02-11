package com.zeconslab.apispring.SpringBootExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

	private static final Logger log = LogManager.getLogger(SpringBootExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
		log.debug("Mensaje de debug en el main ");
	}

}
