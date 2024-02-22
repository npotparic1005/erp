package com.erp.prodaja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdajaApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "prodaja-server");
		SpringApplication.run(ProdajaApplication.class, args);
	}

}
