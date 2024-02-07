package com.zeconslab.apispring.SpringBootExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

	private static Logger log = LoggerFactory.getLogger(SpringBootExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);

		log.debug("Mensaje de debug en el main ");
	}

}
