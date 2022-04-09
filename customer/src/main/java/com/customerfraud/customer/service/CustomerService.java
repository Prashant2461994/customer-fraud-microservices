package com.customerfraud.customer.service;

import org.springframework.stereotype.Service;

import com.customerfraud.customer.model.Customer;
import com.customerfraud.customer.model.CustomerRegistrationRequest;

@Service
public class CustomerService {

	public void register(CustomerRegistrationRequest customerRegRe) {
		
		Customer customer = Customer.builder()
				.firstName(customerRegRe.getFistName())
				.lastName(customerRegRe.getLastName())
				.email(customerRegRe.getEmail())
				.build();
		//todo: check if email valid
		//todo: check if email not takem
		//todo: store customer in db
	}
}
