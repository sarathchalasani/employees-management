package com.emp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
		"com.emp.controllers","com.emp.service","",})
@EntityScan("com.emp.model")
@EnableJpaRepositories("com.emp.dao")
public class EmployeeApp {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApp.class, args);
	}
}
