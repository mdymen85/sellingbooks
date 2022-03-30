package com.bookstore.payment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Payment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Payment2Application.class, args);
	}

}
