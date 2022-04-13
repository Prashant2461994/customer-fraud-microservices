package com.customerfraud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.customerfraud.clients.fraud")
public class CustomerApplication {
	public static void main(String args[]) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
