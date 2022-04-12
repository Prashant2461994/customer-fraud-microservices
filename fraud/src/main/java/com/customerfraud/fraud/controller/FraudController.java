package com.customerfraud.fraud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerfraud.fraud.model.FraudCheckResponse;
import com.customerfraud.fraud.service.FraudCheckService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check/")
@Slf4j
public class FraudController {
	
	@Autowired
	private  FraudCheckService fraudCheckService; 
	


	@GetMapping(path="{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
		log.info("Customer {} fraud check",new Object[] {customerId});
		boolean isFraudlentCustomer =fraudCheckService.isFradulentCustomer(customerId);
		return new FraudCheckResponse(isFraudlentCustomer);
	}
}
