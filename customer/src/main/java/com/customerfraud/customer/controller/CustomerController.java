package com.customerfraud.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerfraud.customer.model.CustomerRegistrationRequest;
import com.customerfraud.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
		log.info("new customer registration {}", customerRequest);
		customerService.register(customerRequest);
	}
}
