package com.customerfraud.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customerfraud.clients.fraud.model.FraudCheckResponse;


@FeignClient(name = "fraud",url = "${clients.fraud.url}")
public interface FraudClient {
	
	@GetMapping(path="api/v1/fraud-check/{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);

}
