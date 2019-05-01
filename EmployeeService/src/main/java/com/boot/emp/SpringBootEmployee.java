package com.boot.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.controllers")
public class SpringBootEmployee {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployee.class, args);
	}
}
