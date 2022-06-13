package com.BookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
		System.out.println("Book Start");
	}

}
