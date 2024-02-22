package com.erp.roba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobaApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "roba-server");
		SpringApplication.run(RobaApplication.class, args);
	}

}
