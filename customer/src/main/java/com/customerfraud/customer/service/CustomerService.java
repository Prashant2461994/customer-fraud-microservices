package com.customerfraud.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customerfraud.amqp.producer.RabbitMQMessageProducer;
import com.customerfraud.clients.fraud.FraudClient;
import com.customerfraud.clients.fraud.model.FraudCheckResponse;
import com.customerfraud.clients.fraud.model.NotificationRequest;
import com.customerfraud.customer.config.CustomerConfig;
import com.customerfraud.customer.model.Customer;
import com.customerfraud.customer.model.CustomerRegistrationRequest;
import com.customerfraud.customer.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FraudClient fraudClient;
	
	@Autowired
	RabbitMQMessageProducer producer;
	
	
	@Autowired
	CustomerConfig config;
	

	public void register(CustomerRegistrationRequest customerRegRe) {

		Customer customer = Customer.builder().firstName(customerRegRe.getFistName())
				.lastName(customerRegRe.getLastName()).email(customerRegRe.getEmail()).build();

		
		customerRepository.saveAndFlush(customer);
		
		FraudCheckResponse fraudCheckResponse =	fraudClient.isFraudster( customer.getId());
	
		if (fraudCheckResponse.getIsFraudster()) {
			throw new IllegalStateException("fraudster");
		}

		// todo: check if email valid
		// todo: check if email not takem
		// todo: store customer in db
	    // todo: send notification
        // todo: make it async. i.e add to queue
	  NotificationRequest notificationRequest = new NotificationRequest(
		                                        customer.getId(),
		                                        customer.getEmail(),
		                                        String.format("Hi %s, welcome to CustomerFraudApplication...",
		                                        customer.getFirstName())
		                                        );
		
		producer.publish(notificationRequest, config.getInternalExchange(), config.getInternalNotificationRoutingKeyExchange());
	}
}
