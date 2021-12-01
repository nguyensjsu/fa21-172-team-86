package com.example.springemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.example.springcustomer"})
@EnableJpaRepositories("com.example.springcustomer.customerrepository")
public class SpringEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeApplication.class, args);
	}

}
